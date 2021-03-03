package com.wb.pro.util;

import com.lowagie.text.pdf.codec.Base64;
import com.wb.pro.bean.ReportEnum;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.HtmlResourceHandler;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class ReportExportUtil {


    /**
     * 统一pdf/excel/html打印 (方便单元测试)
     *
     * @param outputFileName 不带后缀
     * @param inputStream
     * @param pattern
     * @param param
     * @param list
     * @param response
     * @throws Exception
     */
    public void print3(String outputFileName, JasperDesign jdesign, String pattern, Map param, List<? extends Object> list, HttpServletResponse response) throws Exception {
        if (pattern.equals(ReportEnum.EXCEL.getName())) {
            ReportExportUtil.exportExcel(jdesign, param, list, outputFileName + ".xls", response);
        } else if (pattern.equals(ReportEnum.HTML.getName())) {
            ReportExportUtil.exportHtmlWithImages(jdesign, param, list, response);
        } else if (pattern.equals(ReportEnum.PDF.getName())) {
            ReportExportUtil.exportPDF(jdesign, param, list, outputFileName + ".pdf", response);
        }
    }

    /**
     * 统一pdf/excel/html打印 (方便单元测试)
     *
     * @param outputFileName 不带后缀
     * @param inputStream
     * @param pattern
     * @param param
     * @param list
     * @param response
     * @throws Exception
     */
    public void print2(String outputFileName, InputStream inputStream, String pattern, Map param, List<? extends Object> list, HttpServletResponse response) throws Exception {
        JasperDesign jdesign = JRXmlLoader.load(inputStream);
        if (pattern.equals(ReportEnum.EXCEL.getName())) {
            ReportExportUtil.exportExcel(jdesign, param, list, outputFileName + ".xls", response);
        } else if (pattern.equals(ReportEnum.HTML.getName())) {
            ReportExportUtil.exportHtmlWithImages(jdesign, param, list, response);
        } else if (pattern.equals(ReportEnum.PDF.getName())) {
            ReportExportUtil.exportPDF(jdesign, param, list, outputFileName + ".pdf", response);
        }
    }


    /**
     * 统一pdf/excel/html打印 (方便单元测试)
     *
     * @param outputFileName 不带后缀
     * @param inputStream
     * @param pattern
     * @param param
     * @param list
     * @param response
     * @throws Exception
     */
    public static void print(String outputFileName, InputStream inputStream, String pattern, Map param, List<?> list, HttpServletResponse response) throws Exception {
        JasperDesign jdesign = JRXmlLoader.load(inputStream);
        if (pattern.equals(ReportEnum.EXCEL.getName())) {
            ReportExportUtil.exportExcel(jdesign, param, list, outputFileName + ".xls", response);
        } else if (pattern.equals(ReportEnum.HTML.getName())) {
            ReportExportUtil.exportHtmlWithImages(jdesign, param, list, response);
        } else if (pattern.equals(ReportEnum.PDF.getName())) {
            ReportExportUtil.exportPDF(jdesign, param, list, outputFileName + ".pdf", response);
        }
    }

    /**
     * 导出html能显示图片
     *
     * @throws Exception
     */
    public static <T> void exportHtmlWithImages(JasperPrint jprint, OutputStream outputStream) throws Exception {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jprint));
        //html显示图片,重写handleResource getResourcePath
        SimpleHtmlReportConfiguration reportExportConfiguration = new SimpleHtmlReportConfiguration();
        exporter.setConfiguration(reportExportConfiguration);
        SimpleHtmlExporterOutput simpleHtmlExporterOutput = new SimpleHtmlExporterOutput(outputStream);
        Map<String, String> images = new HashMap<>(16);
        simpleHtmlExporterOutput.setImageHandler(new HtmlResourceHandler() {
            @Override
            public void handleResource(String id, byte[] data) {
                images.put(id, "data:image/jpg;base64," + Base64.encodeBytes(data));
                log.debug("image 2 base64");
            }

            @Override
            public String getResourcePath(String id) {
                return images.get(id);
            }
        });
        exporter.setExporterOutput(simpleHtmlExporterOutput);
        exporter.exportReport();
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 导出html能显示图片
     *
     * @param jdesign
     * @param params
     * @param data
     * @param response
     * @throws Exception
     */
    public static <T> void exportHtmlWithImages(JasperDesign jdesign, Map params, List<T> data, HttpServletResponse response) throws Exception {
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, new JRBeanCollectionDataSource(data));
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        exportHtmlWithImages(jprint, response.getOutputStream());
    }

    public static void exportHtml(JasperPrint jprint, OutputStream outputStream) throws JRException, IOException {
        HtmlExporter exporter = new HtmlExporter();
        exporter.setExporterInput(new SimpleExporterInput(jprint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(outputStream));
        exporter.exportReport();
        outputStream.flush();
        outputStream.close();
    }

    public static void exportHtml(JasperDesign jdesign, Map params, List data, HttpServletResponse response) throws Exception {
        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, new JRBeanCollectionDataSource(data));
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        exportHtml(jprint, response.getOutputStream());

    }

    public static void exportExcel(JasperDesign jdesign, Map params, List data, String fileName, HttpServletResponse response) throws Exception {

        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, new JRBeanCollectionDataSource(data));
//            JasperExportManager.exportReportToPdfFile(jprint, "/Users/ycjx/baobiao/print.xls");


        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "utf-8") + "\"");
        response.setCharacterEncoding("UTF-8");

        SimpleXlsReportConfiguration simpleXlsReportConfiguration = new SimpleXlsReportConfiguration();
        simpleXlsReportConfiguration.setOnePagePerSheet(true);
        simpleXlsReportConfiguration.setRemoveEmptySpaceBetweenColumns(true);
        simpleXlsReportConfiguration.setRemoveEmptySpaceBetweenRows(true);
        simpleXlsReportConfiguration.setWhitePageBackground(false);

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setConfiguration(simpleXlsReportConfiguration);
        exporter.setExporterInput(new SimpleExporterInput(jprint));
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/ycjx/baobiao/print.xls"));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        response.getOutputStream().flush();
        response.getOutputStream().close();


    }

    public static void exportPDF(JasperDesign jdesign, Map params, List data, String fileName, HttpServletResponse response) throws Exception {

        JasperReport jreport = JasperCompileManager.compileReport(jdesign);
        JasperPrint jprint = JasperFillManager.fillReport(jreport, params, new JRBeanCollectionDataSource(data));
//            JasperExportManager.exportReportToPdfFile(jprint, "/Users/ycjx/baobiao/print.pdf");


        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "utf-8") + "\"");
        response.setCharacterEncoding("UTF-8");

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jprint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
        exporter.exportReport();
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}

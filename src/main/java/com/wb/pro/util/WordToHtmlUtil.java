package com.wb.pro.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

/**
 * @author: WangBin
 * @create: 2020-02-27 21:37
 **/
public class WordToHtmlUtil {

//    public static String docToHtml(File file) throws Exception {
//        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(file));
//        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
//        // 保存图片，并返回图片的相对路径
//        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
//            File imgfile = new File(name);
//            OutputStream output = null;
//            BufferedOutputStream bufferedOutput = null;
//            try {
//                output = new FileOutputStream(imgfile);
//                bufferedOutput = new BufferedOutputStream(output);
//                bufferedOutput.write(content);
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    bufferedOutput.close();
//                    output.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            String url = "https://bs-read.best-seeing.cn/42925824357438278/bgimg/42925824357438278.png";
//            imgfile.delete();
//            return url;
//        });
//        wordToHtmlConverter.processDocument(wordDocument);
//        Document htmlDocument = wordToHtmlConverter.getDocument();
//        DOMSource domSource = new DOMSource(htmlDocument);
////        File htmlFile = new File(Global.getUserfilesBaseDir()+IdWorker.getIdStr()+".html");
//        StreamResult streamResult = new StreamResult(htmlFile);
//        TransformerFactory tf = TransformerFactory.newInstance();
//        Transformer serializer = tf.newTransformer();
//        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//        serializer.setOutputProperty(OutputKeys.METHOD, "html");
//        serializer.transform(domSource, streamResult);
//        String sCurrentLine="";
//        String sTotalString="";
//        java.io.BufferedReader l_reader = new java.io.BufferedReader(
//                new java.io.InputStreamReader(new FileInputStream(htmlFile)));
//        while ((sCurrentLine = l_reader.readLine()) != null) {
//            sTotalString += sCurrentLine ;//+ "/r/n"
//            System.out.println(sCurrentLine);
//        }
//        l_reader.close();
//        htmlFile.delete();
//        return sTotalString;
//    }

//    // docx转换为html
//    public static String docxToHtml(File file) throws Exception {
////		OutputStreamWriter outputStreamWriter = null;
//        try {
//            XWPFDocument document = new XWPFDocument(new FileInputStream(file));
////			XHTMLOptions options = XHTMLOptions.create();
//            // 2) Prepare XHTML options (here we set the IURIResolver to
//            // load images from a "word/media" folder)
//            File imageFolderFile = new File(Global.getUserfilesBaseDir()+"11");
//            XHTMLOptions options = XHTMLOptions.create().URIResolver(
//                    new FileURIResolver(imageFolderFile));
//            options.setExtractor(new FileImageExtractor(imageFolderFile));
//            // 存放图片的文件夹
////			options.setExtractor(new FileImageExtractor(new File(Global.getUserfilesBaseDir())));
//            // html中图片的路径
////			options.URIResolver(new BasicURIResolver("image"));
//            String descFileName = Global.getUserfilesBaseDir()+IdWorker.getIdStr()+".html";
//            FileUtils.createFile(descFileName);
//            File htmlFile = new File(descFileName);
////			outputStreamWriter = new OutputStreamWriter(new FileOutputStream(htmlFile), "utf-8");
//            XHTMLConverter.getInstance().convert(document, new FileOutputStream(htmlFile), options);
//
//            String sCurrentLine="";
//            String sTotalString="";
//            java.io.BufferedReader l_reader = new java.io.BufferedReader(
//                    new java.io.InputStreamReader(new FileInputStream(htmlFile)));
//            while ((sCurrentLine = l_reader.readLine()) != null) {
//                sTotalString += sCurrentLine ;//+ "/r/n"
//                System.out.println(sCurrentLine);
//            }
//            l_reader.close();
//            htmlFile.delete();
//            return CmsUtils.contentReImg(sTotalString,"1");
//        } finally {
////			if (outputStreamWriter != null) {
////				outputStreamWriter.close();
////			}
//        }
//    }

}

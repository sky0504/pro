package com.wb.pro.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @author: WangBin
 * @create: 2020-02-28 08:47
 **/
public class WordToHtmlUtilTest {

    public static void main(String[] args) throws Throwable {
        final String path = "/Volumes/Work/work/";
        final String file = "个税2.doc";
        InputStream input = new FileInputStream(path + file);
        HWPFDocument wordDocument = new HWPFDocument(input);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder()
                        .newDocument());
        // 保存图片，并返回图片的相对路径
        wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
            LogPrintUtil.systemOutPrintln("image name----" + name);
            File imgfile = new File(name);
            OutputStream output = null;
            BufferedOutputStream bufferedOutput = null;
            try {
                output = new FileOutputStream(imgfile);
                bufferedOutput = new BufferedOutputStream(output);
                bufferedOutput.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedOutput.close();
                    output.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String url = "https://bs-read.best-seeing.cn/42925824357438278/bgimg/42925824357438278.png";
            imgfile.delete();
            return url;
        });
        wordToHtmlConverter.processDocument(wordDocument);
        Document htmlDocument = wordToHtmlConverter.getDocument();

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(outStream);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        outStream.close();
        String content = new String(outStream.toByteArray());
        LogPrintUtil.systemOutPrintln(content);
        FileUtils.writeStringToFile(new File(path, "人员选择系分.html"), content, "utf-8");
    }

//    public String docxToHtml1() throws IOException, ParserConfigurationException, TransformerException {
//        final String path = "/Volumes/Work/work/";
//        final String file = "个税.doc";
//        InputStream in = new FileInputStream(path + file);
//        // 1) 加载word文档生成 XWPFDocument对象
//        XWPFDocument wordDocument = new XWPFDocument(in);
//        XWPFPictureData xwpfPictureData=wordDocument.getAllPictures();
////        XHTMLOptions options = XHTMLOptions.create();
////        // 存放图片的文件夹
////        options.setExtractor(new FileImageExtractor(new File(imagePath)));
////        // html中图片的路径
////        options.URIResolver(new BasicURIResolver("image"));
////        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
////        XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
////        xhtmlConverter.convert(document, outputStreamWriter, options);
//
//
//
//        List pics = wordDocument.getAllPictures();
//        if (pics != null) {
//            for (int i = 0; i < pics.size(); i++) {
//                Picture pic = (Picture) pics.get(i);
//                try {
//                    pic.writeImageContent(new FileOutputStream(path
//                            + pic.suggestFullFileName()));
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        Document htmlDocument = wordToHtmlConverter.getDocument();


//        String content = new String(outStream.toByteArray());
//        LogPrintUtil.systemOutPrintln(content);
//        FileUtils.writeStringToFile(new File(path, "人员选择系分1.html"), content, "utf-8");

    // 也可以使用字符数组流获取解析的内容
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();

//        XHTMLConverter.getInstance().convert(document, baos, null);
//        String content = baos.toString();
//        baos.close();
//        return content;
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

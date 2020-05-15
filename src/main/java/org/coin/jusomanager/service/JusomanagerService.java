package org.coin.jusomanager.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Service
public class JusomanagerService {
	
	@Value("${juso.url}")
	String jusoUrl;

	public void run(String type) throws IOException {
		
		File zipFile = downloadZip(type);
		
		List<String> filePathList = extractZip(zipFile);
		
		for (String filePath : filePathList) {
			insertToDB(filePath);
		}
		
	}

	private void insertToDB(String filePath) {
		// TODO Auto-generated method stub
		
	}

	private List<String> extractZip(File zipFile) throws IOException {
		ZipFile zip = new ZipFile(zipFile);
		
		return null;
	}

	private File downloadZip(String type) throws IOException {
		
		WebClient webClient = new WebClient();
		
		// JavaScript에서 다운로드 태그가 생성되므로 활성화해야함
		webClient.getOptions().setJavaScriptEnabled(true);
		
		// 초기화시 Ajax 요청이 있으므로 선언 필요
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		
		HtmlPage page = webClient.getPage(jusoUrl);
		List<Object> downloadList;
		if (type.contentEquals("A")) {
			// 전체 데이터 다운로드 태그
			downloadList = page.getByXPath("//div[@id='monthGeoAllDownNum']/a");
		} else {
			// 월변동 데이터 다운로드 태그
			downloadList = page.getByXPath("//div[@id='monthGeoChangeDownNum']/a");
		}
		// 최신 데이터 다운로드
		HtmlAnchor htmlAnchor = (HtmlAnchor) downloadList.get(downloadList.size()-1);
		htmlAnchor.click();
		webClient.waitForBackgroundJavaScript(1000);
		
		Page downloadPage = webClient.getCurrentWindow().getEnclosedPage();
		
		// 다운로드 위치 지정
		File destFile = new File(System.getProperty("java.io.tmpdir"), "temp.zip");
	    try (InputStream contentAsStream = downloadPage.getWebResponse().getContentAsStream()) {
	        try (OutputStream out = new FileOutputStream(destFile)) {
	            IOUtils.copy(contentAsStream, out);
	        }
	    }

	    webClient.close();
	    System.out.println("Output written to " + destFile.getAbsolutePath());   
	    return destFile;
	}

}

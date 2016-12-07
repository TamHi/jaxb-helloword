package vn.tamhi.jaxbhello.main;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import vn.tamhi.jaxbhello.generated.ObjectFactory;
import vn.tamhi.jaxbhello.generated.TUrl;
import vn.tamhi.jaxbhello.generated.Urlset;

public class Main {
	
	public static void main(String[] args) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Urlset urlset = (Urlset) unmarshaller.unmarshal(new File("sitemap.xml"));
		StringWriter sw = new StringWriter();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.marshal(urlset, sw);
		String xmlString = sw.toString();
		System.out.println(xmlString);
//		List<TUrl> list = urlset.getUrl();
//		for(TUrl tUrl : list) {
//			StringWriter sw = new StringWriter();
//			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//			marshaller.marshal(tUrl, sw);
//			String xmlString = sw.toString();
//			System.out.println(xmlString);
////			System.out.println(tUrl.getLoc());
//		}
	}
}

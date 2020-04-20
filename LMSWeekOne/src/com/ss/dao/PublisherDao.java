/**
 * 
 */
package com.ss.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.ss.model.Publisher;

/**
 * @author Alfred
 *
 */
public class PublisherDao {

	public Publisher publisher;
	public Map<Integer, Publisher> publisherMap = new HashMap<>();

	public void readPublisherFile() {

		String getFileLine;
		try (BufferedReader bufferRead = new BufferedReader(new FileReader("./resources/publishers"))) {

			while ((getFileLine = bufferRead.readLine()) != null) {
				String[] token = getFileLine.split("/");

				publisher = new Publisher(Integer.parseInt(token[0]), token[1], token[2]);
				publisherMap.put(publisher.getPublisherId(), publisher);
			}

		} catch (IOException e) {
			System.out.println("The file was not found!");
		}
	}

	public void writePublisherFile(String path) {
		
		String data = " ";

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {

			for (Publisher author : publisherMap.values()) {
				this.publisher = author;
				data = this.publisher.getPublisherId() + "/" + publisher.getPublisherName() + "/"+ publisher.getPublisherAddress() + "\n";
				if (data != "\n" || data != null)
					writer.write(data);
			}

		} catch (IOException e) {
			System.out.println("File Not Found");
		}
	}

}

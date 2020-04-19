/**
 * 
 */
package com.ss.service;

import java.util.Random;

import com.ss.dao.PublisherDao;
import com.ss.interfaces.LoadFiles;
import com.ss.model.Publisher;

/**
 * @author Alfred
 *
 */
public class PublisherService implements LoadFiles {

	PublisherDao publisherDao = new PublisherDao();

	public String createPublisher(String publisherName, String publisherAddress) {
		publisherDao.readPublisherFile();
		Random rand = new Random();
		Integer publisherId = rand.nextInt(100000);
		publisherId += 1;

		if (publisherDao.publisherMap.containsKey(publisherId) == true) {
			while (true) {
				publisherId = rand.nextInt(100000);
				publisherId += 1;
				if (publisherDao.publisherMap.containsKey(publisherId) != true) {
					break;
				}
			}
		}

		if (publisherDao.publisherMap.entrySet().stream()
				.anyMatch(p -> p.getValue().getPublisherName().equalsIgnoreCase(publisherName))) {
			return "Publisher is already in the database";
		} else if (publisherDao.publisherMap.entrySet().stream()
				.anyMatch(p -> p.getValue().getPublisherAddress().equalsIgnoreCase(publisherAddress))) {
			return "Publisher can't have the same address as another Publisher";
		}

		if (publisherName != null && publisherAddress != null) {
			if (publisherName.length() > 3 && publisherName.length() < 45) {
				if (publisherAddress.length() > 3 && publisherAddress.length() < 45) {
					publisherDao.publisher = new Publisher(publisherId, publisherName, publisherAddress);
					publisherDao.publisherMap.put(publisherDao.publisher.getPublisherId(), publisherDao.publisher);
					publisherDao.writePublisherFile();
					return "Publisher was Created";

				} else {
					return "The Publishers Adress is less then 3 characters or is longer then 45 characters";
				}
			} else {
				return "The Publishers Name is less then 3 characters or is longer then 45 characters";
			}
		} else
			return "Names cannot be null!";

	}

	public String updatePublisher(String publisherName, String publisherNewName, String publisherNewAddress) {

		if (publisherName != null && publisherNewName != null && publisherNewAddress != null) {

			if (publisherDao.publisherMap.entrySet().stream()
					.anyMatch(p -> p.getValue().getPublisherName().equalsIgnoreCase(publisherName))) {

				if (!publisherNewName.equalsIgnoreCase("NO CHANGE")
						&& !publisherNewAddress.equalsIgnoreCase("NO CHANGE")) {
					if (publisherNewName.length() > 3 && publisherNewName.length() < 45
							&& publisherNewAddress.length() > 3 && publisherNewAddress.length() < 45) {
						publisherDao.publisherMap.entrySet().stream().forEach((a) -> {
							if (a.getValue().getPublisherName().equalsIgnoreCase(publisherName)) {
								a.getValue().setPublisherName(publisherNewName);
								a.getValue().setPublisherAddress(publisherNewAddress);
								publisherDao.writePublisherFile();
							}
						});
					} else {
						return "publishers new name you entered is ess then 3 characters or is longer then 45 characters";
					}
				}

				if (!publisherNewName.equalsIgnoreCase("NO CHANGE")) {
					if (publisherNewName.length() > 3 && publisherNewName.length() < 45) {
						publisherDao.publisherMap.entrySet().stream().forEach((a) -> {
							if (a.getValue().getPublisherName().equalsIgnoreCase(publisherName)) {
								a.getValue().setPublisherName(publisherNewName);
								publisherDao.writePublisherFile();
							}
						});
					} else {
						return "publishers new name you entered is ess then 3 characters or is longer then 45 characters";
					}
				}

				if (!publisherNewAddress.equalsIgnoreCase("NO CHANGE")) {
					if (publisherNewAddress.length() > 3 && publisherNewAddress.length() < 45) {
						publisherDao.publisherMap.entrySet().stream().forEach((a) -> {
							if (a.getValue().getPublisherName().equalsIgnoreCase(publisherName)) {
								a.getValue().setPublisherAddress(publisherNewAddress);
								publisherDao.writePublisherFile();
							}
						});
					} else {
						return "publishers new Address you entered is ess then 3 characters or is longer then 45 characters";
					}

				}

			} else {
				return "Publisher was not found in database";
			}
		} else {
			return "you can't have a null value for a name or address";
		}
		return "Publisher Has been updated";

	}

	public void readPublisher() {
		publisherDao.publisherMap.entrySet().stream().forEach((p) -> {
			System.out.println("Publisher Name: " + p.getValue().getPublisherName() + " Address: "
					+ p.getValue().getPublisherAddress());
		});
	}

	public String deletePublisher(String publisherName) {

		if (publisherDao.publisherMap.entrySet()
				.removeIf(a -> a.getValue().getPublisherName().equalsIgnoreCase(publisherName))) {
			publisherDao.writePublisherFile();
			return "Publisher was removed from the database";
		}
		return "No Publisher by that name was found";

	}

	@Override
	public void loadFiles() {
		publisherDao.readPublisherFile();
	}

}

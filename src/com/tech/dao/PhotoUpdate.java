package com.tech.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PhotoUpdate {

	public static boolean delete(String path) {

		boolean isDeleated = false;

		File file = new File(path);

		String absolutePath = file.getAbsolutePath();

		System.out.println(absolutePath);

		isDeleated = file.delete();

		return isDeleated;
	}

	public static boolean update(InputStream inputStream, String path) {

		boolean isUpdated = false;
		byte[] imageArray;

		try {

			imageArray = new byte[inputStream.available()];

			inputStream.read(imageArray);


			FileOutputStream stream = new FileOutputStream(path);

			stream.write(imageArray);
			stream.flush();
			stream.close();
			isUpdated=true;

		} catch (IOException e) {

			e.printStackTrace();

		}

		return isUpdated;
	}
}

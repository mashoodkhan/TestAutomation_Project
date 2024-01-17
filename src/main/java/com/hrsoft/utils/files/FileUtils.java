package com.hrsoft.utils.files;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class FileUtils {

	// Method to move files to the archive directory
	public static void moveFilesToArchive() {
		File reportDirectory = new File(System.getProperty("user.dir") + "/reports");
		File archiveDirectory = new File(System.getProperty("user.dir") + "/reports/archive");
		File[] files = reportDirectory.listFiles();

		if (files == null) {
			return;
		}

		Date threeDaysAgo = Date.from(LocalDate.now().minusDays(3).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

		Arrays.stream(files)
		.filter(file -> file.lastModified() < threeDaysAgo.getTime())
		.forEach(file -> {File destinationFile = new File(archiveDirectory, file.getName());
			if (file.renameTo(destinationFile)) {
				System.out.println("File moved to archive: " + destinationFile.getAbsolutePath());
			} else {
				System.out.println("Failed to move file: " + file.getAbsolutePath());
			}
		});
	}

	public void Util_DeleteOldFilesInArchive() {
		try {
			File folder = new File(System.getProperty("user.dir") + "/reports/Archive");
			for (File file : folder.listFiles())
				if (!file.isDirectory())
					file.delete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

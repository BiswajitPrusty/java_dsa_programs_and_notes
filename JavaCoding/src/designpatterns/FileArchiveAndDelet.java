package designpatterns;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileArchiveAndDelet {

    public static void main(String[] args) {
        String folderPath = "C:\\Users\\BiswajitPrusty\\Desktop\\docs\\Testing\\";
        archiveFile(folderPath);
        deleteOldZipFiles(folderPath);
    }

    public static void archiveFile(String folderPath) {
        // Path to the main folder you want to scan
        // Get the current date
        Date currentDate = new Date();

        // Create a calendar instance and set it to 7 days ago
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date thresholdDate = calendar.getTime();

        // Create a Path object representing the main folder to scan
        Path mainFolder = Paths.get(folderPath);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String zipFileName = "archive_" + dateFormat.format(currentDate) + ".zip";
        // Traverse the main folder structure recursively
        try {
            Files.walk(mainFolder)
                    .filter(Files::isDirectory)
                    .forEach(subfolder -> {
                        // Get the subfolder path
                        Path subfolderPath = subfolder.toAbsolutePath();

                        // Get a list of files in the current subfolder that are 7 days or older
                        File[] filesToArchive = subfolderPath.toFile().listFiles(file ->
                                file.isFile() &&
                                        !file.getName().endsWith(".zip") &&
                                        file.lastModified() <= thresholdDate.getTime()
                        );

                        // Check if there are any files to archive in the current subfolder
                        if (filesToArchive != null && filesToArchive.length > 0) {

                            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(subfolderPath + "/" + zipFileName))) {
                                for (File file : filesToArchive) {
                                    // Add each file to the zip file
                                    String entryName = subfolderPath.relativize(file.toPath()).toString();
                                    zipOutputStream.putNextEntry(new ZipEntry(entryName));
                                    Files.copy(file.toPath(), zipOutputStream);
                                    zipOutputStream.closeEntry();
                                    System.out.println("file path name "+ file.toPath());
//                                    file.delete();
                                }

                                System.out.println("Files archived successfully in: " + subfolderPath);
                            } catch (IOException e) {
                                System.out.println("Error archiving files in " + subfolderPath + ": " + e.getMessage());
                            }
                        } else {
                            System.out.println("No files found to archive in: " + subfolderPath);
                        }
                    });

        } catch (IOException e) {
            System.out.println("Error traversing the main folder: " + e.getMessage());
        }
    }

    public static void deleteOldZipFiles(String folderPath) {
        // Get the current date
        Date currentDate = new Date();

        // Create a calendar instance and set it to 30 days ago
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -0);
        Date thresholdDate = calendar.getTime();

        // Create a Path object representing the main folder to scan
        Path mainFolder = Paths.get(folderPath);

        // Traverse the main folder structure recursively
        try {
            Files.walk(mainFolder)
                    .filter(Files::isDirectory)
                    .forEach(subfolder -> {
                        // Get the subfolder path
                        Path subfolderPath = subfolder.toAbsolutePath();

                        // Get a list of files in the current subfolder that are zip files and 30 days or older
                        File[] zipFilesToDelete = subfolderPath.toFile().listFiles(file ->
                                file.isFile() &&
                                        file.getName().endsWith(".zip") &&
                                        file.lastModified() <= thresholdDate.getTime()
                        );

                        // Check if there are any zip files to delete in the current subfolder
                        if (zipFilesToDelete != null && zipFilesToDelete.length > 0) {
                            for (File zipFile : zipFilesToDelete) {
                                // Delete each zip file
                                if (zipFile.delete()) {
                                    System.out.println("Zip file Name :"+zipFile.getName());
                                    System.out.println("Zip file path Name :"+zipFile.getPath());
                                    System.out.println("Deleted file: " + zipFile.getAbsolutePath());
                                } else {
                                    System.out.println("Failed to delete file: " + zipFile.getAbsolutePath());
                                }
                            }
                        } else {
                            System.out.println("No zip files found to delete in: " + subfolderPath);
                        }
                    });

        } catch (Exception e) {
            System.out.println("Error deleting zip files: " + e.getMessage());
        }
    }
}

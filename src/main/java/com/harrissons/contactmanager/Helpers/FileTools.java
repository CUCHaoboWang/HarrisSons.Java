package com.harrissons.contactmanager.Helpers;

import com.opencsv.CSVReader;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

/**
 * File Tools
 *
 * @author Bob
 */
public class FileTools {
    /**
     * Copy File
     *
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        // New File Input Stream
        FileInputStream input = new FileInputStream(sourceFile);
        BufferedInputStream inBuff = new BufferedInputStream(input);

        // New File Output Stream
        FileOutputStream output = new FileOutputStream(targetFile);
        BufferedOutputStream outBuff = new BufferedOutputStream(output);

        byte[] b = new byte[1024 * 5];
        int len;
        while ((len = inBuff.read(b)) != -1) {
            outBuff.write(b, 0, len);
        }
        outBuff.flush();

        // Close Stream
        inBuff.close();
        outBuff.close();
        output.close();
        input.close();
    }

    /**
     * Copy Directory
     *
     * @param sourceDir
     * @param targetDir
     * @throws IOException
     */
    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        // Create Target Directory
        (new File(targetDir)).mkdirs();
        // Get All Files From Source Directory
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // Source File
                File sourceFile = file[i];
                // Target File
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                // Prepare Source Directory
                String dir1 = sourceDir + "/" + file[i].getName();
                // Prepare Target Directory
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }

    /**
     * Get File MD5
     *
     * @param file
     * @return
     */
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte[] buffer = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get File SHA-1
     *
     * @param file
     * @return
     */
    public static String getFileSha1(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte[] buffer = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("SHA-1");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * Clear Directory
     *
     * @param dir
     */
    public static void clearDirectiory(String dir) throws IOException {
        File dirFile = new File(dir);
        for (File file : Objects.requireNonNull(dirFile.listFiles())) {
            file.delete();
        }
    }

    /**
     * Read CSV File To ArrayList
     *
     * @param csvFile
     * @return ArrayList<String [ ]>
     * @throws IOException
     */
    public static ArrayList<String[]> getCsvFileContentList(File csvFile) throws IOException {
        FileReader fReader = null;
        CSVReader csvReader = null;
        ArrayList<String[]> list = new ArrayList<>();

        try {
            // initialize reader
            fReader = new FileReader(csvFile);
            csvReader = new CSVReader(fReader);
            // read csv file
            list = (ArrayList<String[]>) csvReader.readAll();
            return list;

        } catch (IOException e) {
            throw e;
        } finally {
            if (fReader != null) {
                try {
                    fReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (csvReader != null) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Read SQL File To ArrayList
     *
     * @param sqlFile
     * @return ArrayList<String>
     * @throws IOException
     */
    public static ArrayList<String> getSqlFileContentList(File sqlFile) throws IOException {
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader br = null;
        try {
            // initialize reader
            br = new BufferedReader(new InputStreamReader(new FileInputStream(sqlFile), StandardCharsets.UTF_8));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                lineTxt = lineTxt.trim();
                if ("".equals(lineTxt) || lineTxt.startsWith("//")) {
                    // escape comment and empty lines
                } else {
                    if (lineTxt.contains("//")) {
                        // escape comment
                        lineTxt = lineTxt.substring(0, lineTxt.indexOf("//")).trim();
                    }
                    list.add(lineTxt);
                }
            }
            return list;

        } catch (IOException e) {
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Format File Size
     *
     * @param fileS
     * @return
     */
    public static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }
}


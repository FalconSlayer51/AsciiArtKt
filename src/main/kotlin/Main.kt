package org.example

import java.io.File
import java.io.FileWriter
import kotlin.random.Random

fun main() {
    val asciiArt = AsciiArt()
    // the lower the scale the better the image
    // scale > 0
    val art = asciiArt.convertImageToAsciiArt(
        path = "C:\\Users\\K.RAMESH\\Downloads\\GNnhSMlbEAAmk14.jpg",
        scale = 3
    )

    val folderName = "E:\\Code\\asciiArtMain\\AsciiImages"
    val folder = File(folderName)
    folder.mkdirs()

    val fileName = "AsciiImages\\${Random.nextInt()}.txt"
    val file = File(fileName)
    val fileWriter = FileWriter(fileName)
    if (file.exists()) {
        fileWriter.write(art)
    }else{
        println("Some thing went wrong in file creation")
    }
    fileWriter.close()
}
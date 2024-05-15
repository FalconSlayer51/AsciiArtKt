package org.example

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class AsciiArt {
    private fun getAscii(grayValue: Int): Char {
        val index: Int = grayValue / 32
        val ascii = listOf<Char>(' ', '.', ',', '-', '~', '+', '=', '@')
        return ascii[index]
    }
    fun convertImageToAsciiArt(path: String,scale: Int): String {
        val imageFile = File(path)
        val image: BufferedImage = ImageIO.read(imageFile)
        val height = image.height
        val width = image.width
        val sb = StringBuilder()

        for (y in 0 until height) {
            for(x in 0 until width) {
                if (y%(scale *2) == 0 && x%scale == 0) {
                    val pixel = image.getRGB(x, y)
                    val red = (pixel shr 16) and 0xFF
                    val green = (pixel shr 8) and 0xFF
                    val blue = pixel and 0xFF
                    val alpha = (pixel shr 24) and 0xFF

                    var grayValue = (red / 3) + (green /3) + (blue/3)
                    if (alpha == 0) grayValue = 0
                    sb.append(getAscii(grayValue))
                }
            }
            if (y % (scale * 2) == 0) sb.append('\n')
        }
        return sb.toString()
    }
}
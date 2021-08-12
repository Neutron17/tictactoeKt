package com.neutron.io

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.util.*
import kotlin.jvm.Throws

object Reader {
    /** Read a single char from a file */
    @Throws(FileNotFoundException::class)
    fun readSingleChar(path:String) {
        val fis = FileInputStream(path) // File path
        val i = fis.read()
        println(i.toChar())
        fis.close()
    }
    /** Read multiple chars from a file */
    @Throws(FileNotFoundException::class)
    fun readMultipleChar(path: String) {
        val fis = FileInputStream(path) // File path
        var i = 0
        var result = ""
        while (fis.read().also { i = it } != -1) {
            result += i.toChar()
        }
        println(result)
        fis.close()
        println("Finished")
    }
    /** Read multiple chars with buffer */
    @Throws(FileNotFoundException::class)
    fun bufferedReader(path: String) {
        val fis = FileInputStream(path); // File path
        val bin = BufferedInputStream(fis);
        var i: Int;
        var result = "";
        while (bin.read().also { i = it } != -1) {
            result += i.toChar();
        }
        println(result);
        fis.close();
    }
    @Throws(FileNotFoundException::class)
    fun read(path:String):String {
        val file = File(path);
        val sc = Scanner(file);
        while (sc.hasNextLine()) {
            var data = sc.nextLine();
            println(data);
            return data;
        }
        sc.close();
        return "";
    }
}
package com.neutron.io

import java.io.*
import kotlin.jvm.Throws

object Writer {
    /** Write singe character to  file */
    @JvmStatic
    @Throws(FileNotFoundException::class)
    fun writeWithAscii(ascii:Int,path:String) {
        val fos = FileOutputStream(path)
        fos.write(ascii)
        fos.flush()
        fos.close()
    }
    @JvmStatic
    @Throws(FileNotFoundException::class)
    fun writeMultipleChar(text: String,path: String) {
        try {
            val fos = FileOutputStream(path)
            val a = text.toByteArray()
            fos.write(a)
            fos.flush()
            fos.close()
        } catch (ex: Exception) {
            println("" + ex)
        }
    }
    /** Write multiple chars with buffer */
    @JvmStatic
    @Throws(FileNotFoundException::class)
    fun bufferedWriter(text: String, path: String) {
        val f = File(path)
        bufferedWriter(text, f)
    }
    /** Write multiple chars with buffer */
    @JvmStatic
    @Throws(FileNotFoundException::class)
    fun bufferedWriter(text: String, file: File) {
        val fos = FileOutputStream(file)
        val bout = BufferedOutputStream(fos)
        val a = text.toByteArray()
        bout.write(a)
        bout.flush()
        bout.close()
    }
    /** Write to file without overwriting it's content */
    @JvmStatic
    @Throws(IOException::class)
    fun withoutOverwrite(text: String, path: String) {
        val log = File(path)
        withoutOverwrite(text, log)
    }
    /** Write to file without overwriting it's content */
    @JvmStatic
    @Throws(IOException::class)
    fun withoutOverwrite(text: String, file: File) {
        if (!file.exists()) {
            file.createNewFile()
        }
        val fileWriter = FileWriter(file, true)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(text)
        bufferedWriter.close()
    }
    @JvmStatic
    fun write(text: String, file:File, overwrite:Boolean = true) {
        if(!file.exists()) throw FileNotFoundException()
        if(file.isDirectory) throw NotFileException("File is directory")
        if(overwrite) {
            bufferedWriter(text, file)
        }else{
            withoutOverwrite(text, file)
        }
    }

    @JvmStatic
    fun write(text: String, path:String, overwrite:Boolean = true) {
        val file:File = File(path)
        write(text, file, overwrite)
    }
}
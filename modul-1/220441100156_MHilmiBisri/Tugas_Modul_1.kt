package com.example.myapplication

import kotlin.io.readLine
import kotlin.text.toIntOrNull

class Kalkulator {
    fun Tambah(a: Int, b: Int): Int {
        return a + b
    }

    fun Kurang(a: Int, b: Int): Int {
        return a - b
    }

    fun Kali(a: Int, b: Int): Int {
        return a * b
    }

    fun Bagi(a: Int, b: Int): Int? {
        return if (b != 0) {
            a / b
        } else {
            null
        }
    }
}

fun main() {
    while (true) {
        val kalkulator = Kalkulator()

        println("=== Kalkulator ===")
        println("Pilih operasi:")
        println("1. Penjumlahan")
        println("2. Pengurangan")
        println("3. Perkalian")
        println("4. Pembagian")
        println("0. Keluar")

        val input = readLine()
        if (input.isNullOrBlank()) {
            println("Input tidak boleh kosong")
            continue
        }
        val pilihan = input.toIntOrNull()
        if (pilihan == null) {
            println("Input harus berupa angka")
            continue
        }

        when (pilihan) {
            0 -> return
            1 -> {
                println("Masukkan angka pertama:")
                val num1 = readLine()?.toIntOrNull()

                println("Masukkan angka kedua:")
                val num2 = readLine()?.toIntOrNull()

                if (num1 != null && num2 != null) {
                    val hasil = kalkulator.Tambah(num1, num2)
                    println("Hasil penjumlahan: $hasil")
                } else {
                    println("Input tidak valid")
                }
            }
            2 -> {
                println("Masukkan angka pertama:")
                val num1 = readLine()?.toIntOrNull()

                println("Masukkan angka kedua:")
                val num2 = readLine()?.toIntOrNull()

                if (num1 != null && num2 != null) {
                    val hasil = kalkulator.Kurang(num1, num2)
                    println("Hasil pengurangan: $hasil")
                } else {
                    println("Input tidak valid")
                }
            }
            3 -> {
                println("Masukkan angka pertama:")
                val num1 = readLine()?.toIntOrNull()

                println("Masukkan angka kedua:")
                val num2 = readLine()?.toIntOrNull()

                if (num1 != null && num2 != null) {
                    val hasil = kalkulator.Kali(num1, num2)
                    println("Hasil perkalian: $hasil")
                } else {
                    println("Input tidak valid")
                }
            }
            4 -> {
                println("Masukkan angka pertama:")
                val num1 = readLine()?.toIntOrNull()

                println("Masukkan angka kedua:")
                val num2 = readLine()?.toIntOrNull()

                if (num1 != null && num2 != null) {
                    val hasil = kalkulator.Bagi(num1, num2)
                    if (hasil != null) {
                        println("Hasil pembagian: $hasil")
                    } else {
                        println("Tidak bisa melakukan pembagian oleh nol")
                    }
                } else {
                    println("Input tidak valid")
                }
            }
            else -> {
                println("Pilihan tidak valid")
            }
        }
    }
}

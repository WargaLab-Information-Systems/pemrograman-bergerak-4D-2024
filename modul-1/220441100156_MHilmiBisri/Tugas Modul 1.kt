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

    fun Bagi(a: Int, b: Int): Int {
        return a / b
    }
}

fun main() {
    val Kalkulator = Kalkulator()

    println("=== Kalkulator ===")
    println("Pilih operasi:")
    println("1. Penjumlahan")
    println("2. Pengurangan")
    println("3. Perkalian")
    println("4. Pembagian")

    val Pilihan = readLine()?.toIntOrNull()

    if (Pilihan != null) {
        when (Pilihan) {
            1 -> {
                println("Masukkan angka pertama:")
                val num1 = readLine()?.toIntOrNull()

                println("Masukkan angka kedua:")
                val num2 = readLine()?.toIntOrNull()

                if (num1 != null && num2 != null) {
                    val hasil = Kalkulator.Tambah(num1, num2)
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
                    val hasil = Kalkulator.Kurang(num1, num2)
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
                    val hasil = Kalkulator.Kali(num1, num2)
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
                    val hasil = Kalkulator.Bagi(num1, num2)
                    println("Hasil pembagian: $hasil")
                } else {
                    println("Input tidak valid")
                }
            }
            else -> {
                println("Pilihan tidak valid")
            }
        }
    } else {
        println("Input tidak valid")
    }
}
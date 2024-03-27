class Mobil(val nama: String, val hargaPerHari: Int)

fun main() {
    val mobilList =
            listOf(
                    Mobil("Avanza", 450000),
                    Mobil("ertiga", 450000),
                    Mobil("mobilio", 450000),
                    Mobil("Innova", 700000),
                    Mobil("Fortuner", 1500000),
                    Mobil("Pajero", 1500000),
                    Mobil("Xenia", 250000)
            )

    println("Selamat datang di rental mobil Ningrat")
    println("Daftar Mobil Tersedia:")
    println("=======================================")
    for ((index, mobil) in mobilList.withIndex()) {
        println("${index + 1}. ${mobil.nama} - Harga per hari: Rp${mobil.hargaPerHari}")
    }
    println("=======================================")
    println()

    val nomorMobil = 5
    val lamaSewa = 5

    if (nomorMobil < 0 || nomorMobil > mobilList.size) {
        println("Nomor mobil tidak valid.")
        return
    }

    val indexMobil = nomorMobil - 1
    val mobil = mobilList[indexMobil]
    val biayaTotal = mobil.hargaPerHari * lamaSewa

    println("ingin menyewa mobil ${mobil.nama}")
    println("Anda telah menyewa ${mobil.nama} selama $lamaSewa hari.")
    println("Biaya sewa: Rp$biayaTotal")

    val hargabayar = 8000000
    val kembali = hargabayar - biayaTotal

    println("harga bayar Rp. $hargabayar")
    println("uang kembalian Rp. $kembali")
    println("Terima kasih telah menggunakan layanan kami.")
}
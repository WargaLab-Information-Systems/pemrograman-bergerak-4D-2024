fun main() {
    var x = true
    while (x == true) {
        println("==============Toko Kue==============")
        println("===================================")
        println("Apa yang ingin Anda lakukan?")
        println("1. Lihat Daftar Kue \n2. Pesan Kue \n3. Lihat Status Pesanan \nPilih nomor berapa? 1/2/3")
        println("===================================\n")
        println("-----------------------------------")
        val bakery = Bakery()
        println("[1] Daftar Kue")
        bakery.daftar()
        println("===================================")
        println("[2] Pesan Kue")
        bakery.pesan()
        println("===================================")
        println("[3] Lihat Status Pesanan")
        bakery.status()
        println("-----------------------------------")

        var kondisi = "ya"
        if (kondisi == "ya") {
            println("YES")
        } else {
            println("NO")
            bakery.keterangan()

        }
        println("===================================")
        println("Selamat menikmati kue dari toko kami :)")
        println("===================================")
        x = false
    }
}

class Bakery() {
    val kue = " Kue Coklat : Kue Keju : Kue Strawberry"
    var stok = " 10 : 15 : 20"
    var terjual = " 5 : 10 : 15"
    var tersedia = " 5 : 5 : 5"

    fun daftar() {
        println("-----------------------------------")
        println("Daftar Kue yang Tersedia:")
        println(kue)
        println("Stok: $stok")
        println("-----------------------------------")

    }

    fun pesan() {
        println("-----------------------------------")
        println("Jumlah kue yang tersedia:")
        println(kue)
        println("Tersedia: $tersedia")
        println("-----------------------------------")

    }

    fun status() {
        println("--------------------$kue----")
        println("Jumlah kue tersedia: $tersedia")
        println("Jumlah kue terjual : $terjual")

    }

    fun keterangan() {
        println("-----------------------------------")
        println("Selamat menikmati kue dari toko kami")
        println("Stok kue akan diperbarui setiap hari")
    }

}
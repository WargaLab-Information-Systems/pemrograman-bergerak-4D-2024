fun main() {
    println("== Program Penyewaan Wedding Organizer ==")
    println("1. Sewa")
    println("2. Tampilkan Daftar Acara WO")
    println("")

    val wo = Wedding()

    val pilihan = 2

    if (pilihan == 1) {
        wo.sewawo()
    } else if (pilihan == 2) {
        wo.tampilkandaftarwo()
    } else {
        println("Pilihan tidak valid program berakhir")
    }
}

class Wedding {
     val daftarsewa = mutableListOf<String>()

    fun sewawo() {
        println(">Anda memilih penyewaan WO")
        println("Pilih paket WO yang anda butuhkan:")
        println("1. Lamaran")
        println("2. Akad")
		println("")
        
        val pilihan = 2

        if (pilihan == 1) {
            val datasewa = "--DESKRIPSI PENYEWAAN--\nNama Client: Laura\nPaket: Lamaran\nTanggal: 20 Maret 2029\nHarga: Rp 10,000,000"
            println(datasewa)
            println("Terimakasih telah menggunakan jasa kami:)")
            daftarsewa.add(datasewa) 
            println("")
            ulang()
        } else if (pilihan == 2) {
            val datasewa ="--DESKRIPSI PENYEWAAN--\nNama Client: Tasa\nPaket: Akad\nTanggal: 25 Juni 2029\nHarga: Rp 20,000,000"
            println(datasewa)
            println("Terimakasih telah menggunakan jasa kami:)")
            daftarsewa.add(datasewa)
            println("")
            ulang()
        } else {
            println("Pilihan tidak valid")
            return
        }
    }
    fun tampilkandaftarwo() {
        val datasewa ="--DESKRIPSI PENYEWAAN--\nNama Client: Irene\nPaket: Resepsi\nTanggal: 25 Juni 2029\nHarga: Rp 20,000,000"
		daftarsewa.add(datasewa)
        println("Daftar acara yang ada:")
        for (data in daftarsewa) {
            println(data)
            println()
        }
    }

    fun ulang() {
        println("Apakah ada yang lain yang ingin Anda lakukan?")
        println("1. Sewa")
        println("2. Tampilkan Daftar Acara WO")
        println("3. Keluar")

        val pilihan = 2

        if (pilihan == 1) {
            sewawo()
        } else if (pilihan == 2) {
            tampilkandaftarwo()
        } else {
            println("Program berakhir")
        }
    } 
}

class Buku(val judul: String, val pengarang: String, val tahunterbit: Int, var stok: Int) {
    	var denda: Int = 0
    
       	fun pinjam(jumlah: Int) {
        if (jumlah <= stok) {
            stok -= jumlah
            println("Anda telah meminjam " + jumlah + " buku " + judul + " karya " + pengarang + ".")
        } else {
            println("Maaf, stok buku " + judul + " tidak mencukupi.")
        }
    }
    	fun kembalikan(jumlah: Int, terlambat: Int) {
        if (terlambat > 0) {
            denda = terlambat * 1000 
            println("Anda mengembalikan buku terlambat selama " + terlambat + " hari.\nDenda yang harus dibayar: Rp" + denda)
        } else {
            println("Terimakasih anda telah mengembalikan buku tepat waktu.")
        }
        stok += jumlah
    }
        fun bayar(jumlahBayar: Int) {
        if (denda > 0) {
            val kembalian = jumlahBayar - denda
            println("Anda telah membayar denda sebesar: Rp" + denda)
            if (kembalian > 0) {
                println("Kembalian Anda: Rp"+kembalian)
            }
            denda = 0
        } else {
            println("Tidak ada denda yang harus dibayar.")
        }
    }
}
fun main() {
    println("GA PERNAH BACA BUKU? YANG BENERR AJAA RRUGI DONG!!!")
    println("PERPUSTAKAAN NGGA KELILING")
    
    val buku1 = Buku("Laut Bercerita", "Leila Salikha", 2017, 10)
    val buku2 = Buku("Wingit", "Sara Wijayanto", 2020, 5)
    val buku3 = Buku("Home Sweet loan", "Almira Bastari", 2022, 8)
    val buku4 = Buku("Bumi", "Tere Liye", 2014, 5)
    val buku5 = Buku("The Star and I", "Ilana Tan", 2021, 5)

    println("Daftar Buku:")
    println("1. " + buku1.judul + " karya " + buku1.pengarang + " tahun " + buku1.tahunterbit + " -> Stok: " + buku1.stok)
    println("2. " + buku2.judul + " karya " + buku2.pengarang + " tahun " + buku2.tahunterbit + " -> Stok: " + buku2.stok)
    println("3. " + buku3.judul + " karya " + buku3.pengarang + " tahun " + buku3.tahunterbit + " -> Stok: " + buku3.stok)
    println("4. " + buku4.judul + " karya " + buku4.pengarang + " tahun " + buku4.tahunterbit + " -> Stok: " + buku4.stok)
    println("5. " + buku5.judul + " karya " + buku5.pengarang + " tahun " + buku5.tahunterbit + " -> Stok: " + buku5.stok)
    
    println("\nMeminjam buku:")
    buku1.pinjam(2) 
    buku2.pinjam(3) 
    buku5.pinjam(10)
    
    println("\nPinjam sekaligus :")
    val pinjambanyak = listOf(buku1, buku2, buku3, buku4, buku5)
    for (i in pinjambanyak) {
        i.pinjam(2)
    }

    println("\nMengembalikan buku:")
    buku1.kembalikan(1, 0) 
    buku2.kembalikan(2, 2) 
    
    println("\nBayar Denda:")
    buku2.bayar(5000)
}

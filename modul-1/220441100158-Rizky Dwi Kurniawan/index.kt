fun main() {
    println("===== Selamat Datang Di Rental Alat Musik =====")
    println("")
    println("1. Gitar\n2. Ukulele\n3. Biola")
    println("")
    println("Mau Rental Apa? (1/2/3) .....")
    println("2")
    println("")  
    print("=".repeat(47))
    println("")
    
    val rental = 2
    val pembayaran = 100000
    
    val rentalAlatMusik = Rental()
    rentalAlatMusik.transaksi(rental, pembayaran)
    
    println("")
    println("Berapa Penilaian Untuk Layanan Kami? (1-10)")
    println("5")
    println("")
    val nilai = 5
    if (nilai <1){
        println("Penilaian Minimal 1")
    } else if (nilai > 10){
        println("Penilaian Maksimal 10")
    } else{
        for (i in 1 .. nilai) {
        val bintang = "*"
        print(bintang)
		}
    }
    println("")
    println("=".repeat(47))
}

class Rental {
    fun transaksi(rental: Int, pembayaran: Int) {
        val harga: Int

        if (rental == 1) {
            harga = 100000
            println("")
            println("Anda Menyewa Gitar\nHarga : Rp. $harga")
        } else if (rental == 2) {
            harga = 50000
            println("")
            println("Anda Menyewa Ukulele\nHarga : Rp. $harga")
        } else if (rental == 3) {
            harga = 150000
            println("")
            println("Anda Menyewa Biola\nHarga : Rp. $harga")
        } else {
            println("")
            println("Inputan Tidak Valid")
            return
        }

        println("")
        println("Masukkan Nominal Pembayaran")
        println("Rp. $pembayaran")
        println("")
        
        val kembalian = pembayaran - harga

        if (pembayaran == harga) {
            println("Uang Anda Pas \nKembalian = Rp. $kembalian")
        } else if (pembayaran > harga) {
            println("Uang Anda Lebih \nKembalian = Rp. $kembalian")
        } else {
            println("Uang Anda Kurang = Rp. $kembalian")
        }

        println("")
        println("=".repeat(47))
    }
}
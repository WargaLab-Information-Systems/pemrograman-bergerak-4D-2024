
class WiFi(val nama: String, val harga: Int)

class TokoWiFi {
    val wifiTersedia = listOf(
        WiFi("Paket 35 Mbps", 50000),
        WiFi("Paket 20 Mbps", 30000),
        WiFi("Paket 15 Mbps", 20000)
    )

    fun paketWiFi() {
        println("Selamat datang di toko WiFi kami!")
        println("Berikut adalah pilihan WiFi yang tersedia:")
        wifiTersedia.forEachIndexed { index, wifi ->
            println("${index + 1}. ${wifi.nama} - Rp ${wifi.harga}")
        }
    }

    fun beliWiFi(pilihan : Int, saldo: Int): Int {
        if (pilihan < 1 || pilihan > wifiTersedia.size) {
            println("Pilihan tidak valid. Silakan coba lagi.")
            return saldo
        }
        val wifiTerpilih = wifiTersedia[pilihan - 1]

        if (saldo < wifiTerpilih.harga) {
            println("Saldo tidak mencukupi untuk membeli paket WiFi ini.")
            return saldo
        }

        val kembalian = saldo - wifiTerpilih.harga
        println("Anda telah membeli ${wifiTerpilih.nama} seharga Rp ${wifiTerpilih.harga}. Selamat menikmati WiFi!")
        println("Kembalian Anda adalah Rp $kembalian")
        return kembalian
    }
}

fun main() {
    val toko = TokoWiFi()
    var saldo = 500000

    while (true) {
        toko.paketWiFi()
     
        val pilihan = 2
        

        saldo = toko.beliWiFi(pilihan, saldo)
        if (saldo <= 0) {
            println("Saldo Anda habis. Transaksi selesai.")
            break
        }

        break
    }

}











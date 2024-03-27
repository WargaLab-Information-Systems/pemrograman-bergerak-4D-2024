// Class untuk merepresentasikan menu makanan
class Menu(val nama: String, val harga: Int)

// Class untuk merepresentasikan toko makanan
class Toko(val nama: String, val menus: List<Menu>) {
    // Function untuk menampilkan menu yang tersedia
    fun tampilanMenu() {
        println("Selamat datang di $nama")
        println("Menu yang tersedia :")
        menus.forEachIndexed { index, menu ->
            println("${index + 1}. ${menu.nama} - Rp${menu.harga}")
        }
    }

    // Function untuk memesan makanan
    fun pesanMenu(menuIndex: Int): Menu? {
        if (menuIndex in 1..menus.size) {
            return menus[menuIndex - 1]
        }
        return null
    }

    fun batas() {
        for (i in 1..50) {
            print("=")
        }
        println()
    }
    
    fun Uang(bayar: Int, menuIndex: Int): Int {
        val kembalian = bayar - menus[menuIndex - 1].harga
        return kembalian
    }
}

fun main() {
    // Inisialisasi menu-menu toko makanan
    val menus = listOf(
        Menu("Nasi Goreng", 15000),
        Menu("Mie Ayam", 12000),
        Menu("Soto Ayam", 13000),
        Menu("Bakso", 10000),
        Menu("Ayam Goreng", 18000)
    )

    // Inisialisasi Toko
    val toko = Toko("Warung Sederhana", menus)

    // Menampilkan Menu
    toko.batas()
    toko.tampilanMenu()
    toko.batas()

    // Memesan makanan
    val menuIndex = 1
    val bayar = 20000
	val kembali = toko.Uang(bayar, menuIndex)
    val pesanan = toko.pesanMenu(menuIndex)

    if (pesanan != null) {
        println("Anda telah memesan ${pesanan.nama}. Silakan menunggu.")
        toko.batas()
    } else {
        println("Menu tidak tersedia.")
        toko.batas()
    }
    println("Uang yang dibayar sebesar $bayar")
    print("Jadi kembalian nya sebesar $kembali")
}
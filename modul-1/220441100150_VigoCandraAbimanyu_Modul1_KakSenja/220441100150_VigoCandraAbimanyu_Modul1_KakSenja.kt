fun main() {
    println("Selamat datang di aplikasi Farmasi Online") 
    println("======================================================================")
    
    val toko = TokoOnline()
    toko.menu()
    
    println("Silahkan masukkan perintah sesuai dengan pilihan di bawah:")
    println("\nPerintah yang dapat dilakukan:")
    println("1. Beli obat")
    println("2. Cek stok obat ")
    
    var jumlah = 5
    var menu = 1
    var pilihan = 1
    var uang = 100000
    
    var stok = arrayOf(10,10,10,10,10,10)
    var harga = arrayOf(8000,4000,24000,42000,6000,15000)
    var obat = arrayOf("Promag Chew Tablet","Kuldon sariawan","Madu TJ Murni","Listerin Original",
                       "Delcogen Tablet","Bodrexin Demam")
    
    var pilihStok = stok[menu]
    
    if (pilihan == 1) {
        println("Pilih Menu Diatas") 
        if (menu >= 0 && menu <=5){ 
            if(jumlah<=pilihStok && jumlah >0){
            var pilihObat = obat[menu]
            for (i in 1..jumlah){
                pilihStok--
            }
            if(pilihStok <=0){
                pilihStok = 0
            }
            println("Anda Telah Membeli $pilihObat")
//           if(jumlah<pilihStok && jumlah > 0){
            println("Anda membeli sebanyak $jumlah")
            println("Info Stok Obat $pilihObat Sebanyak $pilihStok")
             var pilihHarga = harga[menu]
             var total = pilihHarga * jumlah
             var kembalian = uang-total
             if(uang<total){
                    println("Maaf uang anda kurang, harap masukan dengan benar")
             }else{

                println("Total harga adalah $total")
                println("Uang Anda Adalah $uang")
                println("Maka kembalian anda adalah $kembalian")
             }
                pilihStok--
                stok[menu] = pilihStok
            }else{
                println("Data yang dimasukan tidak benar, coba lagi")
            }
        }else{
            println("Tidak Valid")
        }
        
    }else if(pilihan==2){
        println("Pilih Menu Diatas") 
        if (menu >= 1 && menu <=5){ 
            if (pilihStok <=0){
                println("Stok telah Habis")
            }else{
                println("Stok Masih Tersedia Sebesar $pilihStok")
            }
        }
    }else{
        println("Perintah Tidak Valid")
    }

println("Terima Kasih")

}
    

class TokoOnline {
    fun menu(){
    println("Obat yang tersedia:")
    println("0. Promag Chew Tablet ~ 8,000")
    println("1. Kuldon sariawan ~ 4,000")
    println("2. Madu TJ Murni 500g ~ 24,000")
    println("3. Listerin Original 500ML ~ 42,000") 
    println("4. Delcogen Tablet ~ 6,000")
    println("5. Bodrexin Demam ~ 15,000")
    }
}
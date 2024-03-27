fun main() {
    println("!! Pemberitahuan !!")
    println("Hitungan Main/Jam = 12k \nDengan max bermain 5 jam\n")
    println("==Hanya Terdapat 2 Meja==\n")
    
    val Tanda = DurasiMain()
    val lamaMain = DurasiMain()
    println("================================================================================")
    lamaMain.meja()
    Tanda.garis()
}

class DurasiMain {
    var jam = 1
 	var mejaSatu = 5
    var mejaDua = 1
    var biaya = 12000
    
  
    fun meja() {     
        if (mejaSatu > 5) {
            println("Maaf untuk meja 1, waktu yang di minta terlalu banyak. Max bermain adalah 5 jam.")
        } else{
            val totalHarga1 = jam * biaya * mejaSatu
            println("==> Meja 1 Bermain $mejaSatu JAM :Rp $totalHarga1")
        }
        
        if (mejaDua > 5){
             println("Maaf, waktu terlalu banyak. Max bermain adalah 5 jam.")
        } else{
            val totalHarga2 = jam * biaya * mejaDua
            println("==> Meja 2 Bermain $mejaDua JAM :Rp $totalHarga2")
        }
    println("\n!! Pemberitahuan !!")
    println("Hitungan Main/Jam = 12k \nDengan max bermain 5 jam\n")
    println("==Hanya Terdapat 2 Meja==\n")
    }
 fun garis(){
     for (i in 1..60){
         print("-")
   }
 }
    
}
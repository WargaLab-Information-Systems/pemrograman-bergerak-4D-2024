class Tugas(val nama: String, val deadline: String, var selesai: Boolean = false)

// untuk menampilkan daftar tugas
fun tampilkan_DaftarTugas(daftarTugas: Array<Tugas>) {
    println("====================== Daftar Tugas ==============================")
    for (index in daftarTugas.indices) {
    val tugas = daftarTugas[index]
    println((index + 1).toString() + ". " + tugas.nama + " \t(Dl: " + tugas.deadline + ")")
	}
}

// untuk menampilkan tugas yang sudah selesai
fun tampilkan_TugasSelesai(daftarTugas: Array<Tugas>) {
    println("==================== Tugas yang Sudah Selesai ====================")
    var index = 1
    for (tugas in daftarTugas) {
        if (tugas.selesai) {
            println(index.toString() + ". " + tugas.nama)
            index++
        }
    }
    if (index == 1) {
        println("Tidak ada tugas yang sudah selesai.")
    }
}

// untuk menampilkan tugas yang belum selesai
fun tampilkan_TugasBelumSelesai(daftarTugas: Array<Tugas>) {
    println("==================== Tugas yang Belum Selesai ====================")
    var index = 1
    for (tugas in daftarTugas) {
        if (!tugas.selesai) {
            println(index.toString() + ". " + tugas.nama)
            index++
        }
    }
    if (index == 1) {
        println("Semua tugas yang sudah selesai.")
    }
}

fun main() {
    val daftarTugas = arrayOf(
        Tugas("Membuat relasi dan mindmapping \t(SMBD)", "18 Maret 2024"),
        Tugas("Membuat dokumen SRS dan usecase \t(IPPL)", "27 Maret 2024"),
        Tugas("Mencari alternatif dengan metode SAW (SPK)", "25 Maret 2024"),
        Tugas("Melakukan perbandingan data \t\t(DM)", "01 April 2024"),
    )

    // menampilkan daftar tugas
    tampilkan_DaftarTugas(daftarTugas)

    // menandai tugas sebagai selesai
    daftarTugas[0].selesai = true
    daftarTugas[2].selesai = true
    daftarTugas[3].selesai = true
	
    //menandai tugas belum selesai
    daftarTugas[1].selesai = false
    
    println("\n")
	tampilkan_TugasBelumSelesai(daftarTugas)
    
    println("\n")
    // menampilkan daftar tugas selesai
    tampilkan_TugasSelesai(daftarTugas)
}

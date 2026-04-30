import java.util.Scanner;
import java.util.ArrayList;

public class CetakNilai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<NilaiMahasiswa> listMhs = new ArrayList<>();
        
        System.out.print("Masukkan Jumlah Mahasiswa: ");
        int jumlah = input.nextInt();

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM: "); String nim = input.next();
            System.out.print("Nama: "); String nama = input.next();
            System.out.print("Nilai: "); int nilai = input.nextInt();
            
            if (nilai < 0 || nilai > 100) {
                System.out.println("Input nilai anda salah");
            }
            listMhs.add(new NilaiMahasiswa(nim, nama, nilai));
        }

        // --- OUTPUT SESUAI LAYOUT TUGAS ---
        System.out.println("\n--- HASIL DATA ---");
        double totalNilai = 0;
        int jmlLulus = 0, jmlGagal = 0;
        int gradeA = 0, gradeB = 0, gradeD = 0;
        StringBuilder namaLulus = new StringBuilder();
        StringBuilder namaGagal = new StringBuilder();
        StringBuilder namaA = new StringBuilder();
        StringBuilder namaB = new StringBuilder();

        for (NilaiMahasiswa m : listMhs) {
            System.out.println("NIM: " + m.getNim());
            System.out.println("Nama: " + m.getNama());
            System.out.println("Nilai: " + m.getNilai());
            System.out.println("Grade: " + m.getGrade());
            System.out.println("===");

            totalNilai += m.getNilai();
            
            // Logika Statistik
            if (m.getStatus().equals("Lulus")) {
                jmlLulus++;
                namaLulus.append(m.getNama()).append(", ");
            } else {
                jmlGagal++;
                namaGagal.append(m.getNama()).append(", ");
            }

            if (m.getGrade().equals("A")) {
                gradeA++;
                namaA.append(m.getNama()).append(", ");
            } else if (m.getGrade().equals("B")) {
                gradeB++;
                namaB.append(m.getNama()).append(", ");
            } else if (m.getGrade().equals("D")) {
                gradeD++;
            }
        }

        System.out.println("Jumlah Mahasiswa: " + listMhs.size());
        System.out.println("Jumlah Mahasiswa yg Lulus: " + jmlLulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus: " + jmlGagal + " yaitu " + namaGagal);
        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + gradeA + " yaitu " + namaA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + gradeB);
        System.out.println("Rata-rata nilai mahasiswa adalah: " + (totalNilai / listMhs.size()));
    }
}
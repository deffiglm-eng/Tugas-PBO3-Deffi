public class NilaiMahasiswa extends Mahasiswa {
    private int nilai;
    private String grade;
    private String status;

    public NilaiMahasiswa(String nim, String nama, int nilai) {
        super(nim, nama); // Memanggil constructor dari class Mahasiswa
        this.nilai = nilai;
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            status = "Lulus";
        } else if (nilai >= 70 && nilai <= 79) {
            grade = "B";
            status = "Lulus";
        } else if (nilai >= 60 && nilai <= 69) {
            grade = "C";
            status = "Lulus";
        } else if (nilai >= 50 && nilai <= 59) {
            grade = "D";
            status = "Tidak Lulus";
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            status = "Tidak Lulus";
        } else {
            grade = "Salah Input";
            status = "-";
        }
    }

    // Getter untuk keperluan statistik di Main class
    public int getNilai() { return nilai; }
    public String getGrade() { return grade; }
    public String getStatus() { return status; }
    public String getNama() { return nama; }
    public String getNim() { return nim; }
}
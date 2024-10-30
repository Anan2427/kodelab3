import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Employee merepresentasikan seorang karyawan dengan ID, nama, 
 * dan status kehadiran.
 */
class Employee {
    String id;
    String name;
    boolean isPresent;

    /**
     * Konstruktor untuk membuat objek Employee baru dengan ID dan nama.
     * Secara default, karyawan dianggap tidak hadir.
     *
     * @param id ID unik untuk karyawan
     * @param name Nama karyawan
     */
    Employee(String id, String name) {
        this.id = id;
        this.name = name;
        this.isPresent = false; // Default tidak hadir
    }

    /**
     * Menandai kehadiran karyawan.
     *
     * @param present Status kehadiran (true untuk hadir, false untuk tidak hadir)
     */
    public void markAttendance(boolean present) {
        this.isPresent = present;
    }

    /**
     * Mengembalikan representasi string dari karyawan, termasuk ID, nama,
     * dan status kehadiran.
     *
     * @return Representasi string dari karyawan
     */
    public String toString() {
        return "ID: " + id + ", Nama: " + name + ", Hadir: " + (isPresent ? "Ya" : "Tidak");
    }
}

/**
 * Kelas AttendanceSystem untuk mengelola sistem kehadiran karyawan.
 * Sistem ini memungkinkan pengguna untuk menambahkan karyawan,
 * menandai kehadiran, dan menampilkan laporan kehadiran.
 */
public ckkoclass AttendanceSystem {
    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * Metode utama yang menjalankan sistem kehadiran. Menyediakan antarmuka
     * bagi pengguna untuk memilih opsi dalam sistem.
     *
     * @param args Argumen baris perintah
     */
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Sistem Kehadiran Karyawan ---");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Tandai Kehadiran");
            System.out.println("3. Tampilkan Laporan Kehadiran");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Konsumsi newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    displayAttendanceReport();
                    break;
                case 4:
                    running = false;
                    System.out.println("Keluar... Terima kasih!");
                    break;
                default:
                    System.out.println("Opsi tidak valid! Silakan pilih lagi.");
            }
        }
    }

    /**
     * Menambahkan karyawan baru ke dalam sistem. 
     * Mengambil ID dan nama karyawan dari input pengguna.
     */
    static void addEmployee() {
        System.out.print("Masukkan ID Karyawan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama Karyawan: ");
        String name = scanner.nextLine();
        employees.add(new Employee(id, name));
        System.out.println("Karyawan berhasil ditambahkan!");
    }

    /**
     * Menandai kehadiran karyawan berdasarkan ID yang dimasukkan oleh pengguna.
     * Meminta pengguna untuk memasukkan status hadir (ya/tidak).
     */
    static void markAttendance() {
        System.out.print("Masukkan ID Karyawan untuk menandai kehadiran: ");
        String id = scanner.nextLine();
        for (Employee emp : employees) {
            if (emp.id.equalsIgnoreCase(id)) {
                System.out.print("Apakah karyawan hadir? (ya/tidak): ");
                String present = scanner.nextLine();
                emp.markAttendance(present.equalsIgnoreCase("ya"));
                System.out.println("Kehadiran berhasil ditandai!");
                return;
            }
        }
        System.out.println("Karyawan tidak ditemukan!");
    }

    /**
     * Menampilkan laporan kehadiran dari semua karyawan yang telah ditambahkan
     * ke dalam sistem.
     */
    static void displayAttendanceReport() {
        System.out.println("\n--- Laporan Kehadiran ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

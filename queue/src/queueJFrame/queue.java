/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* Penjelasan bagian perbagian pada program Antrian Ujian Akhir Semester  */

// ini adalah package/paket yang berfungsi untuk mempermudah memaketkan fungsi/method dalam program, sehingga 
//mempermudah programmer untuk mengkelompokkan paketnya
package queueJFrame;

//ini adalah cara untuk mengambil fungsi bawaan pada java yakni mengambil(import linkedlist)  
import java.util.LinkedList;
//ini adalah cara untuk mengambil fungsi bawaan pada java yakni mengambil(import queue)
import java.util.Queue;
//dan yang ini untuk megimport dan menggunakan fungsi pane di java swing
import javax.swing.JOptionPane;

/**
 *
 * @author Kevinmsan
 */
//ini adalah class queue yang extends ke kelas utama(kelas induk pada java swing)
public class queue extends javax.swing.JFrame {
    /**
     * Creates new form queue
     */
    
    //pada kode ini adalah proses membuat objek Queue baru dengan nama antrian pada fungsi Linkedlist yang sudah di import di awal
    Queue<Object> antrian = new LinkedList<>();
    //ini adalah cara kira mendeklarasikan sebuah variabel dengan nama nomor dengan type integer yang diisi dengan nilai default 0(kosong)
    //mengapa diisi dengan kosong? Karena ini akan berhubungan dengan algoritma queue yang ada di bawah kode program ini.
    int nomor = 0;
    
    
    // disini semua kita menginsialisasikan method yang telah buat
    //jadi method yang ada dipanggil dan diinisialsikan pada acceess modifier public queue
    public queue() {
        //ini untuk inisialisasi method initComponents
        initComponents();
        //ini untuk menginisialisasi menthod inisialisasi
        inisialisasi();
    }
    //ini adalah method inisialisasi dan hanya berisi text pada variabel text yang ada pada form
    private void inisialisasi(){
        
        /*pada lnJumlahAntrian berisikan nilai 0 karena ini adalah default ketika tidak ada aktivitas pada program antrian
        jika telah ada maka akan berisi nilai jumlah antrian yang sedang berjalan
        */
        lbJmlAntrian.setText("0");
        /*ini juga berisikan nilai default karena belum ada aktivitas pada program antrian ini akan berubah menjadi nilai 
        yang ada ketika antrian sudah dimulai, contoh sudah ada antrian 1 maka dia akan berubah menjadi total yang ada pada
        atrian*/
        lbTotalAntrian.setText("0");
        lbPanggilAntrian.setText("-----");
        //kode dibawah ini hanya string dan huruf pada tampilan aplikasi
        txtAtas.setText("RS UIN SUSKA RIAU");
        txtAtas1.setText("JL. HR SOEBRANTAS");
        txtAtas2.setText("Pekanbaru");
        txtAtas3.setText("Senin, 28 Juni 2021");
        txtAtas4.setText("Nomor Antrian");
        txtAtas5.setText("--------");
        txtAtas6.setText("Silahkan menunggu");
        txtAtas7.setText("--------");
    }
    
    //ini adalah method tambah Antrian
    /*
    
    Jadi pada method ini terdapat proses menambah jumlah antrian pada aplikasi
    
    */
    //disini kita menggunakan access modeifier private karena dengan menggunakan access ini
    //kita hanya dapat mengakes method ini hanya pada class queue ini saja tidak dapat diakses pada class lainnya.
    //
    private void tambahAntrian(){
        //pada kode ini kita nanti akan melakukan perulangan pada nomor antrian, karena 
        //setiap ada data yang masuk/ nilai baru yang keluar kode ini akan melakukan perulangan pada 
        //nomor selanjutnya
        nomor++;
        //pada bagian ini kita membuat variabel dengan nama antr yang berisi type data String
        //lalu digabuung/dimasukkan dengan variable nomor diatas
        String antr = "Antrian "+nomor;
        //pada bagian kode ini kita menambhakn nilai pada variable antr yang sudah dibuat diatas tadi
        //pada bagian kode ini kita menggunakan salah satu bagian dari algortima linkedlist
        //yakni add, jadi add berfungsi untuk menambahkan data pada sebuah nilai variable
        //disini pada varable antr yang sudah dibuat diatas tadi.
        antrian.add(antr);
        //pada kode berikut ini kita membuat sebuah variable lagi dengan nama cvt dengan type data string
        //lalu kita kembalikan nilai yang ada pada antrian sebagai string yang telah ditentukan yang awalnya adalah integer
        //dan mendapat kan panjang string yang telah di convert tadi pada method valueOf
        String cvt = String.valueOf(antrian.size());
        //kode ini akan mengubah secara langsung pada setText nilai jumlah antrian yang didapat tadi
        lbJmlAntrian.setText(cvt);
        //pada kode berikut ini kita akan melihat data teratas dengan menggunakan method bawaan pada queue tersebut yakni 
        //method bawaan peek(untuk meliha data teratas pada sebuah statck)
        /* 
        Jadi pada program ini terdapat beberapa algoritma didalamnya termasuk stack, jadi ketika data yang ada akan di
        cek dengab peek pada sebuah stack maupun queue
        */
        lbPanggilAntrian.setText(""+antrian.peek());
        //ini akan mengubah nilai total antrian pada text yang ada pada gui
        lbTotalAntrian.setText(""+nomor);
        //ini merupakah salah satu method dari class StringBuffer yang fungsinya untuk menambahkan nilai
        //pada variable antr sehingga nilai akan terupdate/bertambah setiap ada perubahan penambahan data
        txtAntrian.append(antr + "\n");
        // ini hanya text yang ada pada gui 
        //hanya untuk memperbagus tampilan pada gui yang dibuat
        txtAtas3.setText("Senin, 28 Juni 2021");
        txtAtas4.setText("Nomor Antrian");
        //disini terdapat nomor antrian 
        txtAtas5.setText("  " + nomor);
        txtAtas6.setText("Silahkan menunggu " + cvt + " Antrian Lagi ");
        txtAtas7.setText("Mohon untuk bersabar");
    }
    
    //sama dengan method sebelumnya, pada method ini digunakan access modified private agar dapat digunakan dalam 
    //satu class yang sama saja, alasan penggunaan access modified ini adalah agar class lain tidak dapat mengakses dan a
    //alasan keamanan 
    private void prosesAntrian(){
        //pada kode program ini menggunakan salah satu method pada queue yakni isEmpty 
        //disini menggunakan pengecekan data apakah nilai antrian tersebut bernilai null atau kosong
        if(antrian.isEmpty()){
            //jika bernilai kosong/null/empty maka akan menampilkan prompt berikut ini dapat digunakan
            //karena telah mengimport java swing di awal
            JOptionPane.showMessageDialog(this, "Silahkan ambil antrian terlebih dahulu");
        }
        //disini terdapat sebuah variable txtAntrian yang bernilai kosong karena 
        //dalam antrian harus dalam bernilai kosong sebelum di inputkan nilai untuk pertama kali tentunya
        txtAntrian.setText("");
        //pada nilai antrian berikut maka digunakan method/fungsi bawaan queue itu sendiri
        //yakni poll untuk mengatur banyaknya thread/antrian yang dibuat sehingga dapat mengeksekusi 
        //hingga task/queue antrian yang paling akhir
        antrian.poll();
        //selanjutnya antrian tadi yang sudah di isi/berisi tadi akan dilakukan looping dengan menggunakan forEach loop
        //maka semakin banyak antrian maka akan terjadi looping sebanyak data yang masuk diawal
        antrian.forEach((Object element) -> {
            //pada proses ini akan melooping nilai yang ada di dalam forEach itu sendiri
            //dan pada proses ini akan menambhakan data yang secara otomatis sebanyak nilai antrian/queue yang 
            //dimasukkan, ini masih menggunakan class Buffer untuk menambhakan data dengan keyword append
            txtAntrian.append("" + element + "\n");
        });
        //disini masih terdapat pengecekan apakah antrian tersebut masih kosong dengan method bawaan queue itu
        //yakni empty jika masih kosong
        if(antrian.isEmpty()){
            //maka data akan menampilkan hal berikut
            lbPanggilAntrian.setText("-----");
        }else{
            //jika data tidak kosong maka akan menggunakan fungsi peek kembali
            //untuk mengecek apakah data yang masuk sudah sesuai dengan sistem queue itu sendiri
            //yakni FIFO(First in First Out) 
            //Jadi queue itu yang masuk pertama akan keluar yang pertama juga sesuai dengan prinsip antrian
            lbPanggilAntrian.setText(""+antrian.peek());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAntrian = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        lbTotalAntrian = new javax.swing.JLabel();
        lbJmlAntrian = new javax.swing.JLabel();
        lbPanggilAntrian = new javax.swing.JLabel();
        btnProsesAntrian = new javax.swing.JButton();
        btnAmbilNomorAntrian = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtAtas = new javax.swing.JLabel();
        txtAtas1 = new javax.swing.JLabel();
        txtAtas2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtAtas3 = new javax.swing.JLabel();
        txtAtas4 = new javax.swing.JLabel();
        txtAtas5 = new javax.swing.JLabel();
        txtAtas6 = new javax.swing.JLabel();
        txtAtas7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Antrian Pengambilan Obat");

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(145, 436));

        jLabel4.setText("Daftar Antrian");

        txtAntrian.setEditable(false);
        txtAntrian.setColumns(20);
        txtAntrian.setRows(5);
        jScrollPane2.setViewportView(txtAntrian);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        lbTotalAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbTotalAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTotalAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbJmlAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbJmlAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbJmlAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJmlAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbPanggilAntrian.setBackground(new java.awt.Color(255, 255, 204));
        lbPanggilAntrian.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbPanggilAntrian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPanggilAntrian.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnProsesAntrian.setBackground(new java.awt.Color(0, 153, 0));
        btnProsesAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnProsesAntrian.setText("Proses Antrian");
        btnProsesAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesAntrianActionPerformed(evt);
            }
        });

        btnAmbilNomorAntrian.setBackground(new java.awt.Color(0, 153, 0));
        btnAmbilNomorAntrian.setForeground(new java.awt.Color(255, 255, 255));
        btnAmbilNomorAntrian.setText("Ambil Nomor Antrian");
        btnAmbilNomorAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmbilNomorAntrianActionPerformed(evt);
            }
        });

        jLabel5.setText("Loket");

        jLabel6.setText("Mesin Antrian");

        jLabel1.setText("Jumlah Antrian");

        jLabel2.setText("Total Antrian");

        jLabel3.setText("Panggilan Nomor Antrian");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAtas, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(txtAtas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAtas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAtas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtAtas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtAtas7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAtas3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAtas4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAtas5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAtas6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtAtas7, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAtas3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtas7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lbJmlAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(lbTotalAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(142, 142, 142))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbJmlAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(lbTotalAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPanggilAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnProsesAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAmbilNomorAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesAntrianActionPerformed
        //ini adalah method prosesAntrian yang digunakan dalam button Proses Anrian
        //pada proses ini ketika tomnol ditekan maka langsung menuju method yang sudah diinisialisasikan
        prosesAntrian();
    }//GEN-LAST:event_btnProsesAntrianActionPerformed

    private void btnAmbilNomorAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmbilNomorAntrianActionPerformed
        //ini adalah method Ambil Nomor Antrian yang digunakan dalam button Ambil 
         //pada proses ini ketika tomnol ditekan maka langsung menuju method yang sudah diinisialisasikan
        tambahAntrian();
    }//GEN-LAST:event_btnAmbilNomorAntrianActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmbilNomorAntrian;
    private javax.swing.JButton btnProsesAntrian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbJmlAntrian;
    private javax.swing.JLabel lbPanggilAntrian;
    private javax.swing.JLabel lbTotalAntrian;
    private javax.swing.JTextArea txtAntrian;
    private javax.swing.JLabel txtAtas;
    private javax.swing.JLabel txtAtas1;
    private javax.swing.JLabel txtAtas2;
    private javax.swing.JLabel txtAtas3;
    private javax.swing.JLabel txtAtas4;
    private javax.swing.JLabel txtAtas5;
    private javax.swing.JLabel txtAtas6;
    private javax.swing.JLabel txtAtas7;
    // End of variables declaration//GEN-END:variables
}

-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 17, 2018 at 01:19 AM
-- Server version: 5.7.22-0ubuntu0.16.04.1
-- PHP Version: 7.0.30-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `puskesmas_data`
--

-- --------------------------------------------------------

--
-- Table structure for table `daftar_poli`
--

CREATE TABLE `daftar_poli` (
  `id_poli` varchar(5) NOT NULL,
  `nama_poli` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `daftar_poli`
--

INSERT INTO `daftar_poli` (`id_poli`, `nama_poli`) VALUES
('P0002', 'Gigi'),
('P0001', 'Umum');

-- --------------------------------------------------------

--
-- Table structure for table `diagnosa`
--

CREATE TABLE `diagnosa` (
  `id_diagnosa` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `hasil_diagnosa` varchar(100) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` varchar(5) NOT NULL,
  `nama_dokter` varchar(25) NOT NULL,
  `spesialis` varchar(15) DEFAULT NULL,
  `id_poli` varchar(5) DEFAULT NULL,
  `id_login` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `spesialis`, `id_poli`, `id_login`) VALUES
('D0001', 'Suryo Kusumo', 'Gigi', 'P0002', 'A4'),
('D0002', 'Agung Prakoso', 'Umum', 'P0001', 'A3');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_lab`
--

CREATE TABLE `hasil_lab` (
  `id_hasil_lab` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `jenis_tes` varchar(25) DEFAULT NULL,
  `hasil_lab` varchar(100) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hasil_pemeriksaan`
--

CREATE TABLE `hasil_pemeriksaan` (
  `id_hasil` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_dokter` varchar(5) DEFAULT NULL,
  `id_keluhan` varchar(5) DEFAULT NULL,
  `id_diagnosa` varchar(5) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `keluhan`
--

CREATE TABLE `keluhan` (
  `id_keluhan` varchar(5) NOT NULL,
  `keluhan` varchar(200) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `layanan`
--

CREATE TABLE `layanan` (
  `id_layanan` varchar(5) NOT NULL,
  `jenis_pemeriksaan` varchar(50) NOT NULL,
  `biaya_pemeriksaan` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `layanan`
--

INSERT INTO `layanan` (`id_layanan`, `jenis_pemeriksaan`, `biaya_pemeriksaan`) VALUES
('L0001', 'Pemeriksaan Umum', 10000),
('L0002', 'Pemeriksaan Gigi', 15000),
('L0003', 'Surat Keterangan Sehat', 8000),
('L0004', 'Cek Darah Lengkap', 30000),
('L0005', 'Cek Urine Lengkap', 10000),
('L0006', 'Cek Golongan Darah', 10000),
('L0007', 'Cek Glukosa', 12000),
('L0008', 'Tes Narkoba(3P)', 50000),
('L0009', 'Cek Kolesterol', 20000),
('L0010', 'Tes Asam Urat', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `login_user`
--

CREATE TABLE `login_user` (
  `id_login` varchar(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(70) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `acc_non_expired` tinyint(1) NOT NULL,
  `cred_non_expired` tinyint(1) NOT NULL,
  `acc_non_locked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_user`
--

INSERT INTO `login_user` (`id_login`, `username`, `password`, `jabatan`, `enabled`, `acc_non_expired`, `cred_non_expired`, `acc_non_locked`) VALUES
('A1', 'admin@pendaftaran', '{bcrypt}$2a$10$17OxAymymh2KNHDVXHjTXeMD3BnP6SRlYo0Mh9V79yz1OSlrdYgBK', 'Admin Pendaftaran', 1, 1, 1, 1),
('A2', 'admin@keuangan', '{bcrypt}$2a$10$7jD4N9n/EDmG8y5HG0Er9eK8Vz8vFOFnwP9.zc74i/zJU1vZEbqle', 'Admin Keuangan', 1, 1, 1, 1),
('A3', 'dokter@umum', '{bcrypt}$2a$10$vkKc1WalJmlsbhyA8l9UrOeTZAUayeCWsivADqihiRsvIdvxs/EBO', 'Dokter Umum', 1, 1, 1, 1),
('A4', 'dokter@gigi', '{bcrypt}$2a$10$zhKNOrUlN1UgLNTmBIGJp.8d4VduXSzvbjOQAE0oEgsgK/TPHgp1a', 'Dokter Gigi', 1, 1, 1, 1),
('A5', 'laboran@lab', '{bcrypt}$2a$10$1dXyQp7ahRdy.1KuFUKNL.mUtdVkms0lDvi5jYeiJ1v71RlxI4hbG', 'Laboran Lab', 1, 1, 1, 1),
('A6', 'apoteker@farmasi', '{bcrypt}$2a$10$/N/HD.DqkXKRpe/N2e2/Z.bI6mgwZrYfpAJc8C0C/WzkPG8t.zl9C', 'Apoteker Farmasi', 1, 1, 1, 1),
('A7', 'admin@pengelola', '{bcrypt}$2a$10$zp.7/Fz.Caz4gwBfZgtQcunZ.hJwgU/zzPgC.ORdE2YIj5smG0KsO', 'Pengelola Puskesmas', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `medical_record`
--

CREATE TABLE `medical_record` (
  `id_medrec` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_hasil` varchar(5) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` varchar(5) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `stok` int(5) NOT NULL,
  `harga_obat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`id_obat`, `nama_obat`, `stok`, `harga_obat`) VALUES
('O0001', 'Polycrol Forte Tab 10S', 50, 7500),
('O0002', 'Decolgen Tab 10S', 100, 6800),
('O0003', 'Decolgen Syrup 60ML', 200, 12500),
('O0004', 'Amlodipine IF 5mg Tab', 150, 1500),
('O0005', 'Amlodipine IF 10mg Tab', 150, 2300),
('O0006', 'Sanmol Syrup 60ml', 300, 15000),
('O0007', 'Sanmol 500mg Tab Str 4S', 70, 1800),
('O0008', 'Komix Herbal Tube 4S', 230, 9300),
('O0009', 'Komix G-Form Jeruk Nipis 30S', 245, 1250),
('O0010', 'Bisolvon Cough & Flu Syrip 60ml', 350, 45600),
('O0011', 'OBH Combi Anak Batuk Flu Rasa Jeruk 60ml', 231, 13000),
('O0012', 'Bricasma Resp 0.25mg/ml 10S', 320, 13800),
('O0013', 'Asmacel 2mg/5ml Syrup 60ml', 430, 67000),
('O0014', 'Canesten Cr 10g', 102, 42500),
('O0015', 'Bedak Salicyl Menthol Cap Gajah', 250, 8300),
('O0016', 'Minyak Kayu Putih Lang 30ml', 315, 11700),
('O0017', 'Minyak Tawon CC 20ml', 400, 20500),
('O0018', 'Insto TM 7,5ml', 500, 14400),
('O0019', 'Betadine Sol 15ml', 150, 12700),
('O0020', 'Rivanol One Med 300ml', 300, 7000),
('O0021', 'Neo Entrostop Tab Str 12S', 300, 7200);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` varchar(5) NOT NULL,
  `nama_pasien` varchar(100) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `pekerjaan` varchar(30) DEFAULT NULL,
  `jenis_kelamin` enum('L','P') DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `no_telp` varchar(20) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `tgl_lahir`, `pekerjaan`, `jenis_kelamin`, `alamat`, `no_telp`, `tgl_insert`, `tgl_update`) VALUES
('P0001', 'Ghanny Erlangga', '2017-03-14', 'Mahasiswa', 'L', 'P', '0', '0000-00-00', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_resep` varchar(5) DEFAULT NULL,
  `id_layanan` varchar(5) DEFAULT NULL,
  `biaya_obat` int(10) DEFAULT NULL,
  `biaya_lab` int(10) DEFAULT NULL,
  `biaya_dokter` int(10) DEFAULT NULL,
  `tanggal_nota` date DEFAULT NULL,
  `total_biaya` int(20) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id_pendaftaran` int(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_poli` varchar(5) DEFAULT NULL,
  `tanggal_kunjungan` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pendaftaran`
--

INSERT INTO `pendaftaran` (`id_pendaftaran`, `id_pasien`, `id_poli`, `tanggal_kunjungan`) VALUES
(1, 'P0001', 'P0002', '2018-05-17');

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id_resep` varchar(5) NOT NULL,
  `id_obat` varchar(5) DEFAULT NULL,
  `pemakaian` varchar(20) DEFAULT NULL,
  `dosis` varchar(20) DEFAULT NULL,
  `id_pendaftaran` int(5) DEFAULT NULL,
  `tgl_insert` date DEFAULT NULL,
  `tgl_update` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `daftar_poli`
--
ALTER TABLE `daftar_poli`
  ADD PRIMARY KEY (`id_poli`),
  ADD UNIQUE KEY `nama_poli` (`nama_poli`);

--
-- Indexes for table `diagnosa`
--
ALTER TABLE `diagnosa`
  ADD PRIMARY KEY (`id_diagnosa`),
  ADD KEY `id_pasien` (`id_pasien`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`id_dokter`),
  ADD UNIQUE KEY `id_login` (`id_login`),
  ADD KEY `id_poli` (`id_poli`);

--
-- Indexes for table `hasil_lab`
--
ALTER TABLE `hasil_lab`
  ADD PRIMARY KEY (`id_hasil_lab`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`),
  ADD UNIQUE KEY `id_pasien` (`id_pasien`);

--
-- Indexes for table `hasil_pemeriksaan`
--
ALTER TABLE `hasil_pemeriksaan`
  ADD PRIMARY KEY (`id_hasil`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`),
  ADD UNIQUE KEY `id_keluhan` (`id_keluhan`),
  ADD KEY `id_diagnosa` (`id_diagnosa`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_dokter` (`id_dokter`);

--
-- Indexes for table `keluhan`
--
ALTER TABLE `keluhan`
  ADD PRIMARY KEY (`id_keluhan`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`id_layanan`);

--
-- Indexes for table `login_user`
--
ALTER TABLE `login_user`
  ADD PRIMARY KEY (`id_login`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `medical_record`
--
ALTER TABLE `medical_record`
  ADD PRIMARY KEY (`id_medrec`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`),
  ADD KEY `id_hasil` (`id_hasil`),
  ADD KEY `id_pasien` (`id_pasien`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`),
  ADD UNIQUE KEY `nama_pasien` (`nama_pasien`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_resep` (`id_resep`),
  ADD KEY `id_layanan` (`id_layanan`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`id_pendaftaran`),
  ADD UNIQUE KEY `id_pasien` (`id_pasien`),
  ADD UNIQUE KEY `id_poli` (`id_poli`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`id_resep`),
  ADD UNIQUE KEY `id_pendaftaran` (`id_pendaftaran`),
  ADD KEY `id_obat` (`id_obat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  MODIFY `id_pendaftaran` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `diagnosa`
--
ALTER TABLE `diagnosa`
  ADD CONSTRAINT `diagnosa_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`);

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `dokter_ibfk_1` FOREIGN KEY (`id_poli`) REFERENCES `daftar_poli` (`id_poli`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dokter_ibfk_2` FOREIGN KEY (`id_login`) REFERENCES `login_user` (`id_login`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hasil_lab`
--
ALTER TABLE `hasil_lab`
  ADD CONSTRAINT `hasil_lab_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `hasil_lab_ibfk_2` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `hasil_pemeriksaan`
--
ALTER TABLE `hasil_pemeriksaan`
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_2` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_3` FOREIGN KEY (`id_diagnosa`) REFERENCES `diagnosa` (`id_diagnosa`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_4` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `keluhan`
--
ALTER TABLE `keluhan`
  ADD CONSTRAINT `keluhan_ibfk_1` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `medical_record`
--
ALTER TABLE `medical_record`
  ADD CONSTRAINT `medical_record_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `medical_record_ibfk_2` FOREIGN KEY (`id_hasil`) REFERENCES `hasil_pemeriksaan` (`id_hasil`),
  ADD CONSTRAINT `medical_record_ibfk_3` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `pembayaran_ibfk_2` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`),
  ADD CONSTRAINT `pembayaran_ibfk_3` FOREIGN KEY (`id_layanan`) REFERENCES `layanan` (`id_layanan`),
  ADD CONSTRAINT `pembayaran_ibfk_4` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD CONSTRAINT `pendaftaran_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pendaftaran_ibfk_2` FOREIGN KEY (`id_poli`) REFERENCES `daftar_poli` (`id_poli`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `resep_ibfk_2` FOREIGN KEY (`id_obat`) REFERENCES `obat` (`id_obat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `resep_ibfk_3` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

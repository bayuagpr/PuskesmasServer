-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2018 at 05:05 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_puskesmas`
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
  `hasil_diagnosa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `id_dokter` varchar(5) NOT NULL,
  `nama_dokter` varchar(25) NOT NULL,
  `spesialis` varchar(15) DEFAULT NULL,
  `id_poli` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`id_dokter`, `nama_dokter`, `spesialis`, `id_poli`) VALUES
('D0001', 'Suryo Kusumo', 'Umum', 'P0001');

-- --------------------------------------------------------

--
-- Table structure for table `hasil_lab`
--

CREATE TABLE `hasil_lab` (
  `id_hasil_lab` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `jenis_tes` varchar(25) NOT NULL,
  `hasil_lab` varchar(100) NOT NULL,
  `id_pendaftaran` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hasil_pemeriksaan`
--

CREATE TABLE `hasil_pemeriksaan` (
  `id_hasil` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_dokter` varchar(5) DEFAULT NULL,
  `id_diagnosa` varchar(5) DEFAULT NULL,
  `id_pendaftaran` varchar(5) NOT NULL
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

-- --------------------------------------------------------

--
-- Table structure for table `login_user`
--

CREATE TABLE `login_user` (
  `id_login` varchar(5) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `jabatan` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medical_record`
--

CREATE TABLE `medical_record` (
  `id_medrec` varchar(5) NOT NULL,
  `id_pasien` varchar(5) DEFAULT NULL,
  `id_hasil` varchar(5) DEFAULT NULL,
  `id_pendaftaran` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `id_obat` varchar(5) NOT NULL,
  `nama_obat` varchar(30) NOT NULL,
  `stok` int(5) NOT NULL,
  `harga_obat` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `id_pasien` varchar(5) NOT NULL,
  `nama_pasien` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `pekerjaan` varchar(30) NOT NULL,
  `jenis_kelamin` enum('L','P') NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `tgl_lahir`, `pekerjaan`, `jenis_kelamin`, `alamat`, `no_telp`) VALUES
('P0001', 'Ghanny Erlangga', '2017-03-14', 'Mahasiswa', 'L', 'P', '0');

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
  `tanggal_nota` date NOT NULL,
  `total_biaya` int(20) NOT NULL,
  `id_pendaftaran` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id_pendaftaran` varchar(5) NOT NULL,
  `id_pasien` varchar(5) NOT NULL,
  `id_poli` varchar(5) NOT NULL,
  `tanggal_kunjungan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE `resep` (
  `id_resep` varchar(5) NOT NULL,
  `id_obat` varchar(5) DEFAULT NULL,
  `pemakaian` varchar(20) NOT NULL,
  `dosis` varchar(20) NOT NULL,
  `id_pendaftaran` varchar(5) NOT NULL
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
  ADD KEY `id_diagnosa` (`id_diagnosa`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `id_dokter` (`id_dokter`);

--
-- Indexes for table `layanan`
--
ALTER TABLE `layanan`
  ADD PRIMARY KEY (`id_layanan`);

--
-- Indexes for table `login_user`
--
ALTER TABLE `login_user`
  ADD PRIMARY KEY (`id_login`);

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
  ADD CONSTRAINT `dokter_ibfk_1` FOREIGN KEY (`id_poli`) REFERENCES `daftar_poli` (`id_poli`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hasil_lab`
--
ALTER TABLE `hasil_lab`
  ADD CONSTRAINT `hasil_lab_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `hasil_lab_ibfk_2` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `hasil_pemeriksaan`
--
ALTER TABLE `hasil_pemeriksaan`
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_2` FOREIGN KEY (`id_dokter`) REFERENCES `dokter` (`id_dokter`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_3` FOREIGN KEY (`id_diagnosa`) REFERENCES `diagnosa` (`id_diagnosa`),
  ADD CONSTRAINT `hasil_pemeriksaan_ibfk_4` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medical_record`
--
ALTER TABLE `medical_record`
  ADD CONSTRAINT `medical_record_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `medical_record_ibfk_2` FOREIGN KEY (`id_hasil`) REFERENCES `hasil_pemeriksaan` (`id_hasil`),
  ADD CONSTRAINT `medical_record_ibfk_3` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `pembayaran_ibfk_2` FOREIGN KEY (`id_resep`) REFERENCES `resep` (`id_resep`),
  ADD CONSTRAINT `pembayaran_ibfk_3` FOREIGN KEY (`id_layanan`) REFERENCES `layanan` (`id_layanan`),
  ADD CONSTRAINT `pembayaran_ibfk_4` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `resep_ibfk_3` FOREIGN KEY (`id_pendaftaran`) REFERENCES `pendaftaran` (`id_pendaftaran`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

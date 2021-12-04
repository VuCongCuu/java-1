create database ass2;
use ass2;
/*tao bang khach hang*/
create table KhachHang(
idKH int identity primary key,
maKH varchar(20),
tenKH nvarchar(100),
cmt varchar(10) unique,
sdt varchar(10) unique,
email varchar(50) unique,
ngaysinh date,
gioitinh int check(gioitinh>=0 AND gioitinh<=2),
addres nvarchar(100),
loaiKH int check(loaiKH>=0 and loaiKH<=1)
)
/* tao bang tai khoan*/
create table TaiKhoan(
idTK int identity primary key,
idKH int, CONSTRAINT PK_idKH FOREIGN KEY (idKH) REFERENCES KhachHang(idKH),
soTK varchar(6) unique,
loaiTK int check (loaiTK>=1 and loaiTK<=2 ),
trangthai int check (trangthai>=1 and trangthai<=2 ),
ngaytao date,
soDuTK int check(soDuTK>=0),
hanmuc int not null
)
/*Tao bang giao dich*/
create table GiaoDich(
idGD int identity primary key,
soTKGD varchar(6), CONSTRAINT FK_soTK FOREIGN KEY (soTKGD) REFERENCES TaiKhoan(soTK),
loaiTT int check(loaiTT>=1 AND loaiTT<=2),
sotien int check (sotien>0),
ngayGD date,
addressGD nvarchar(100)
)
insert into GiaoDich(soTKGD,loaiTT,sotien,ngayGD,addressGD) values('123456',1,1235456,'1/1/2020','Ha Noi')
insert into GiaoDich(soTKGD,loaiTT,sotien,ngayGD,addressGD) values('123456',1,1235456,'9/9/2020','Ha Noi')
select * from KhachHang
select * from TaiKhoan
select * from GiaoDich

drop table GiaoDich
drop table TaiKhoan
drop table KhachHang


INSERT INTO KhachHang(maKH,tenKH,cmt,sdt,email,gioitinh,addres,loaiKH) values('KH1','Vu Cong Cuu','163310070','0962997321','congcuu1102@gmail.com',1,'Nam Dinh',1)
INSERT INTO KhachHang(maKH,tenKH,cmt,sdt,email,ngaysinh,gioitinh,addres,loaiKH) values('KH2','Vu Linh ','163310071','0962997322','congcuu1103@gmail.com','03/09/1997',0,'Nam Dinh',0)
INSERT INTO KhachHang values('KH3','Vu Linh ','163310072','0962997323','congcuu1104@gmail.com','03/09/1997',0,'Nam Dinh',0)
Update KhachHang set maKH='KH2',tenKH='Vu Cong Cuu',cmt='123123123',sdt='0123123123',email='?',ngaysinh='09/03/1996',gioitinh=1,addres='?',loaiKH=1 where maKH='KH1' ;
delete from KhachHang where maKH = 'KH2'
select * from KhachHang
select idKH,maKH,tenKH,cmt,sdt,email,gioitinh,addres,loaiKH from KhachHang

//loaiTK 0: trai khoan tra truoc 1 : tk tra sau visa
//trang thai 0:disable,1: active

insert into TaiKhoan values (1,'123456',1,1,'03/09/1997',100000,20000)

insert into TaiKhoan(idKH,soTK,loaiTK,trangthai,ngaytao,soDuTK,hanmuc) values (2,'234567',1,,'03/09/1997',100000,20000)
Update TaiKhoan set sotien=2000000 where soTK=123456
Update TaiKhoan set sotien=2000000 where soTK=234567
Update TaiKhoan set sotien=2000000 where soTK=123457



insert into GiaoDich(soTKGD,loaiTT,sotien,ngayGD,addressGD) values('123456',1,1235456,'03/11/2020','Ha Noi')
insert into GiaoDich(soTKGD,loaiTT,sotien,ngayGD,addressGD) values('123456',1,1235456,'2021/1/1','Ha Noi')
select * from GiaoDich

SELECT * FROM  KhachHang as a INNER JOIN TaiKhoan as b ON b.idKH=a.idKH where maKH='1'
SELECT maKH,tenKH,addres,loaiKH,loaiTK,sotien,hanmuc FROM  KhachHang as a 
INNER JOIN TaiKhoan as b ON b.idKH=a.idKH
INNER JOIN GiaoDich as c ON c.soTK=b.soTK
where maKH='1'
SELECT * FROM  TaiKhoan as a 
INNER JOIN GiaoDich as c ON c.soTK=a.soTK
where idKH='1'
maKH,tenKH,addres,loaiKH,soTK,loaiTK,sotien,hanmuc,loaiTT,sotien,ngayGD,addressGD

SELECT * FROM  TaiKhoan as a 
INNER JOIN GiaoDich as c ON c.soTK=a.soTK
where  ngayGD>='2020/09/30' And ngayGD<='2021/1/1'And soTK='123456' ORDER BY ngayGD ASC
where idKH='1'
Select * from GiaoDich where  ngayGD>='2020/09/30' And ngayGD<='2021/1/1'And soTK='123456' ORDER BY ngayGD ASC

SELECT * FROM  KhachHang as a  INNER JOIN TaiKhoan as b ON b.idKH=a.idKH INNER JOIN GiaoDich as c ON c.soTKGD=b.soTK where  maKH='1' ORDER BY ngayGD ASC,soTK ASC
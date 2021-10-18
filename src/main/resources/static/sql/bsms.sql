USE [master]
GO
/****** Object:  Database [bsms]    Script Date: 10/19/2021 12:42:10 AM ******/
CREATE DATABASE [bsms]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bsms', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\bsms.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'bsms_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\bsms_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [bsms] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bsms].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bsms] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bsms] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bsms] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bsms] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bsms] SET ARITHABORT OFF 
GO
ALTER DATABASE [bsms] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bsms] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bsms] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bsms] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bsms] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bsms] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bsms] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bsms] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bsms] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bsms] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bsms] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bsms] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bsms] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bsms] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bsms] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bsms] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bsms] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bsms] SET RECOVERY FULL 
GO
ALTER DATABASE [bsms] SET  MULTI_USER 
GO
ALTER DATABASE [bsms] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bsms] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bsms] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bsms] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [bsms] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'bsms', N'ON'
GO
ALTER DATABASE [bsms] SET QUERY_STORE = OFF
GO
USE [bsms]
GO
/****** Object:  Table [dbo].[account]    Script Date: 10/19/2021 12:42:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[password] [varchar](128) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[account_role]    Script Date: 10/19/2021 12:42:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account_role](
	[account_id] [int] NOT NULL,
	[role_id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 10/19/2021 12:42:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[account_id] [int] NOT NULL,
	[address] [varchar](255) NULL,
	[first_name] [varchar](255) NULL,
	[last_name] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[persistent_logins]    Script Date: 10/19/2021 12:42:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[persistent_logins](
	[username] [varchar](100) NOT NULL,
	[series] [varchar](64) NOT NULL,
	[token] [varchar](64) NOT NULL,
	[last_used] [timestamp] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[series] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 10/19/2021 12:42:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [int] NOT NULL,
	[name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([account_id], [email], [password]) VALUES (1, N'mlzovozlm@gmail.com', N'$2a$10$otXjDbpXhyVU8cIrGtzc4OVCa8EF55bpR8SBVykg6DQOx4jyyZHqm')
INSERT [dbo].[account] ([account_id], [email], [password]) VALUES (2, N'abcxyz@gmail.com', N'$2a$10$otXjDbpXhyVU8cIrGtzc4OVCa8EF55bpR8SBVykg6DQOx4jyyZHqm')
INSERT [dbo].[account] ([account_id], [email], [password]) VALUES (3, N'qwerty@gmail.com', N'$2a$10$otXjDbpXhyVU8cIrGtzc4OVCa8EF55bpR8SBVykg6DQOx4jyyZHqm')
SET IDENTITY_INSERT [dbo].[account] OFF
GO
INSERT [dbo].[account_role] ([account_id], [role_id]) VALUES (1, 1)
INSERT [dbo].[account_role] ([account_id], [role_id]) VALUES (2, 3)
GO
INSERT [dbo].[customer] ([account_id], [address], [first_name], [last_name], [phone]) VALUES (1, N'thuy khue', N'firstname', N'lastname', N'999111234')
GO
INSERT [dbo].[role] ([role_id], [name]) VALUES (1, N'ROLE_CUSTOMER')
INSERT [dbo].[role] ([role_id], [name]) VALUES (2, N'ROLE_EMPLOYEE')
INSERT [dbo].[role] ([role_id], [name]) VALUES (3, N'ROLE_MANAGER')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UK_q0uja26qgu1atulenwup9rxyr]    Script Date: 10/19/2021 12:42:12 AM ******/
ALTER TABLE [dbo].[account] ADD  CONSTRAINT [UK_q0uja26qgu1atulenwup9rxyr] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[account_role]  WITH CHECK ADD  CONSTRAINT [FK1f8y4iy71kb1arff79s71j0dh] FOREIGN KEY([account_id])
REFERENCES [dbo].[account] ([account_id])
GO
ALTER TABLE [dbo].[account_role] CHECK CONSTRAINT [FK1f8y4iy71kb1arff79s71j0dh]
GO
ALTER TABLE [dbo].[account_role]  WITH CHECK ADD  CONSTRAINT [FKrs2s3m3039h0xt8d5yhwbuyam] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[account_role] CHECK CONSTRAINT [FKrs2s3m3039h0xt8d5yhwbuyam]
GO
USE [master]
GO
ALTER DATABASE [bsms] SET  READ_WRITE 
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Admin]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Admin](
	[adminId] [int] IDENTITY(1,1) NOT NULL,
	[adminName] [varchar](50) NOT NULL,
	[adminPassword] [varchar](50) NOT NULL,
	[adminRole] [int] NOT NULL,
	[adminRemark] [varchar](2000) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[adminId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'代表每个管理员唯一标识。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Admin', @level2type=N'COLUMN', @level2name=N'adminId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员名称' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Admin', @level2type=N'COLUMN', @level2name=N'adminName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员密码。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Admin', @level2type=N'COLUMN', @level2name=N'adminPassword'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'管理员权限，1、2、3、4' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Admin', @level2type=N'COLUMN', @level2name=N'adminRole'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Admin', @level2type=N'COLUMN', @level2name=N'adminRemark'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Dep]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Dep](
	[depId] [int] IDENTITY(1,1) NOT NULL,
	[depName] [varchar](50) NOT NULL,
	[depRemark] [varchar](2000) NULL,
 CONSTRAINT [PK_Dep] PRIMARY KEY CLUSTERED 
(
	[depId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'代表每一个部门唯一标识。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Dep', @level2type=N'COLUMN', @level2name=N'depId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门名称。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Dep', @level2type=N'COLUMN', @level2name=N'depName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门备注。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Dep', @level2type=N'COLUMN', @level2name=N'depRemark'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ReceiveLog]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ReceiveLog](
	[receiveLogId] [int] IDENTITY(1,1) NOT NULL,
	[logMessageId] [int] NOT NULL,
	[reveiveLogEmpId] [int] NOT NULL,
 CONSTRAINT [PK_ReceiveLog] PRIMARY KEY CLUSTERED 
(
	[receiveLogId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'代表每一个接收者' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'ReceiveLog', @level2type=N'COLUMN', @level2name=N'receiveLogId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志Id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'ReceiveLog', @level2type=N'COLUMN', @level2name=N'logMessageId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'接收员工Id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'ReceiveLog', @level2type=N'COLUMN', @level2name=N'reveiveLogEmpId'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[EmpCheckLogEmail]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[EmpCheckLogEmail](
	[empCheckLogEmailId] [int] IDENTITY(1,1) NOT NULL,
	[empId] [int] NOT NULL,
	[checkEmpId] [int] NOT NULL,
	[empCheckLogEmailRemark] [varchar](2000) NULL,
 CONSTRAINT [PK_EmpCheckLogEmail] PRIMARY KEY CLUSTERED 
(
	[empCheckLogEmailId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工指定收日志员工关系唯一标识' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'EmpCheckLogEmail', @level2type=N'COLUMN', @level2name=N'empCheckLogEmailId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'写日志员工Id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'EmpCheckLogEmail', @level2type=N'COLUMN', @level2name=N'empId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'收日志员工Id' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'EmpCheckLogEmail', @level2type=N'COLUMN', @level2name=N'checkEmpId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志备注' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'EmpCheckLogEmail', @level2type=N'COLUMN', @level2name=N'empCheckLogEmailRemark'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[LogMessage]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[LogMessage](
	[logMessageId] [int] IDENTITY(1,1) NOT NULL,
	[logMessageEmpId] [int] NULL,
	[logMessageTitle] [varchar](50) NULL,
	[logMessageContent] [varchar](2000) NULL,
	[logMessageTime] [datetime] NULL,
	[logMessagePlan] [int] NULL,
	[logMessageRemark] [varchar](2000) NULL,
 CONSTRAINT [PK_LogMessage] PRIMARY KEY CLUSTERED 
(
	[logMessageId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'代表每一个日志唯一标识' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工Id，写日志的员工（因为上图是类图所以是Emp类型，在表中表现是logMessageEmpId，int类型）。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageEmpId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志标题。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageTitle'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志类容。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageContent'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志编写时间。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageTime'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'日志完成等级，1-10' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessagePlan'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'备注' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'LogMessage', @level2type=N'COLUMN', @level2name=N'logMessageRemark'

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Emp]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Emp](
	[empId] [int] IDENTITY(1,1) NOT NULL,
	[empDepId] [int] NOT NULL,
	[empJob] [varchar](50) NULL,
	[empName] [varchar](50) NOT NULL,
	[empSex] [int] NOT NULL,
	[empBirthday] [datetime] NOT NULL,
	[empTel] [varchar](50) NULL,
	[empEmail] [varchar](50) NOT NULL,
	[empAddress] [varchar](100) NULL,
	[empPassword] [varchar](50) NOT NULL,
	[empRemark] [varchar](2000) NULL,
 CONSTRAINT [PK_Emp] PRIMARY KEY CLUSTERED 
(
	[empId] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'代表每个员工唯一标识。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'部门id，员工属于那个部门(因为以上图是类图，所以是Dep类型，在表中表现是empDepId，int类型)。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empDepId'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工职务' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empJob'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工姓名。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empName'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工性别。1男0女' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empSex'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工生日。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empBirthday'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工电子邮件地址。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empTel'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工住址。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empEmail'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工密码。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empAddress'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工密码。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empPassword'

GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'员工备注。' ,@level0type=N'SCHEMA', @level0name=N'dbo', @level1type=N'TABLE', @level1name=N'Emp', @level2type=N'COLUMN', @level2name=N'empRemark'

GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ReceiveLog_Emp]') AND parent_object_id = OBJECT_ID(N'[dbo].[ReceiveLog]'))
ALTER TABLE [dbo].[ReceiveLog]  WITH CHECK ADD  CONSTRAINT [FK_ReceiveLog_Emp] FOREIGN KEY([reveiveLogEmpId])
REFERENCES [dbo].[Emp] ([empId])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ReceiveLog_LogMessage]') AND parent_object_id = OBJECT_ID(N'[dbo].[ReceiveLog]'))
ALTER TABLE [dbo].[ReceiveLog]  WITH CHECK ADD  CONSTRAINT [FK_ReceiveLog_LogMessage] FOREIGN KEY([logMessageId])
REFERENCES [dbo].[LogMessage] ([logMessageId])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_EmpCheckLogEmail_Emp]') AND parent_object_id = OBJECT_ID(N'[dbo].[EmpCheckLogEmail]'))
ALTER TABLE [dbo].[EmpCheckLogEmail]  WITH CHECK ADD  CONSTRAINT [FK_EmpCheckLogEmail_Emp] FOREIGN KEY([empId])
REFERENCES [dbo].[Emp] ([empId])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_EmpCheckLogEmail_Emp1]') AND parent_object_id = OBJECT_ID(N'[dbo].[EmpCheckLogEmail]'))
ALTER TABLE [dbo].[EmpCheckLogEmail]  WITH CHECK ADD  CONSTRAINT [FK_EmpCheckLogEmail_Emp1] FOREIGN KEY([checkEmpId])
REFERENCES [dbo].[Emp] ([empId])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_LogMessage_Emp]') AND parent_object_id = OBJECT_ID(N'[dbo].[LogMessage]'))
ALTER TABLE [dbo].[LogMessage]  WITH CHECK ADD  CONSTRAINT [FK_LogMessage_Emp] FOREIGN KEY([logMessageEmpId])
REFERENCES [dbo].[Emp] ([empId])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Emp_Dep]') AND parent_object_id = OBJECT_ID(N'[dbo].[Emp]'))
ALTER TABLE [dbo].[Emp]  WITH CHECK ADD  CONSTRAINT [FK_Emp_Dep] FOREIGN KEY([empDepId])
REFERENCES [dbo].[Dep] ([depId])

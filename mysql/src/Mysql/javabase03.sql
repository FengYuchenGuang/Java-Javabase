#练习 : database03.sql 备份 hsp_db02 和 hsp_db03 库中的数据，并恢复

#备份, 要在 Dos 下执行 mysqldump 指令其实在 mysql 安装目录\bin
#这个备份的文件，就是对应的 sql 语句
mysqldump -u root -p -B hsp_db02 hsp_db03 > d:\\bak.sql

DROP DATABASE hsp_db02;
DROP DATABASE hsp_db03;

#恢复数据库(注意：进入 Mysql 命令行再执行)
source d:\\bak.sql
#第二个恢复方法， 直接将 bak.sql 的内容放到查询编辑器中，执行
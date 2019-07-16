#	eclipse部署web项目至本地的tomcat但在webapps中找不到
	第一次安装或者重新安装eclipse，在部署项目的时候很可能会遇到 eclipse部署web项目至本地的tomcat但在webapps中找不到的问题。这是因为你的eclipse中的server中的项目部署路径没有设置好。因此，你会在你的tomcat中的webapps目录中并没有发现部署的项目，同时你可以在eclipse内置浏览器中输入http://localhost:8080/可以正常打开，但在外部浏览器上打开http://localhost:8080时却没有出现所期望的小猫画面。

#	解决办法：按照以下几种方法以此进行（前三步务必进行）
	1.停止eclipse内的Tomcat服务器(stop)
	2.删除该容器中部署的项目(add and remove)
	3.清除该容器相关数据(window->preferences->Server-->Runtime Enviroment->选中已经存在的运行环境->remove->ok)
	4.添加运行环境(window->preferences->Server-->Runtime Enviroment->Add->......)
	5.打开tomcat的修改界面(双击server框栏下的tomcat就好)
	6.找到servers location，选择第二个(User tomcat Installation)
	7.修改deploy path为webapps
	8.W保存关闭
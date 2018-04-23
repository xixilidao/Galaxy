package galaxy.platform.core;

import galaxy.platform.util.*;
import java.io.*;

/**
 * program: Galaxy
 * 平台核心组件，主要完成整个框架的构建和各类平台插件的加载
 * @author: xujie 许杰
 * create: 2018-04-20 21:33
 **/
public class PlatformCore {

    /**
     *  平台初始化，负责对整个平台以及平台配置的插件进行初始化
     * classname initialize
      * @param
     * @return boolean
     * @author  许杰
     * date   2018/4/20 22:03
     * @version 1.0
     */
    public boolean initialize(){

        readBanner();

        //初始化xml工具
        XmlUtil.newInstance();

        //初始化日志记录器，只有初始化，日志工具才可以使用,单例模式
        LoggerUtil.newInstance();

        LoggerUtil.log.info("Galaxy Platform initialize is beging!!!");

        //核心功能初始化
        //PlatformAddinManager.newInstance().loadAddins();

        LoggerUtil.log.info("Galaxy Platform initialize completed!!!");
        return true;
    }

    private void readBanner(){
        File file = new File("E:\\Java\\project\\Galaxy\\conifg\\platform\\banner");
        BufferedReader bf = null;
        if (file.exists() && file.isFile()) {
            try {
                bf = new BufferedReader(new FileReader(file));

                String content = "";

                while(content != null){
                    content = bf.readLine();

                    if(content == null){
                        break;
                    }
                    System.out.println(content);
                }
                bf.close();
                System.out.println("\r\n");
            }
            catch (IOException e){
                System.out.println("can not find conifg\\platform\\banner");
                e.printStackTrace();
            }
        }
    }
}

package galaxy.platform.core;

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
        System.out.println("Galaxy Platform initialize is beging!!!");

        //核心功能初始化
        PlatformAddinManager.newInstance().loadAddins();

        System.out.println("Galaxy Platform initialize completed!!!");
        return true;
    }
}

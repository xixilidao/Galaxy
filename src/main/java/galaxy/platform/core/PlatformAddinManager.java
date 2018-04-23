package galaxy.platform.core;


import java.util.ArrayList;
import java.util.List;

/**
 * program: Galaxy
 * 平台插件加载器
 * @author: xujie 许杰
 * create: 2018-04-20 21:33
 **/
public class PlatformAddinManager {

    private List<PlatformAddinInterface> ls = new ArrayList<PlatformAddinInterface>();

    private static PlatformAddinManager instance  = null;

    /**
     *  启动插件加载器
     * classname loadAddins
      * @param
     * @return boolean
     * @author  许杰
     * date   2018/4/20 22:02
     * @version 1.0
     */
    public boolean loadAddins(){
        try {
            Class c = Class.forName("helleo");
            if (c != null){
                PlatformAddinInterface addin = (PlatformAddinInterface)c.newInstance();
                ls.add(addin);
            }
            else {
                System.out.println("addins not found");
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            return true;
        }
    }

    /**
     *  以单例模式，得到插件加载器的实例
     * classname newInstance
      * @param
     * @return galaxy.platform.core.PlatformAddinManager
     * @author  许杰
     * date   2018/4/20 22:03
     * @version 1.0
     */
    public static PlatformAddinManager newInstance(){
        if (instance == null){
            instance = new PlatformAddinManager();
        }
        return instance;
    }
}


package galaxy.platform.core;

/**
 * program: Galaxy
 * 平台插件统一接口，所有的平台级插件必须实现该接口
 * @author: xujie 许杰
 * create: 2018-04-20 21:33
 **/
public interface PlatformAddinInterface {

    /**
     *  平台启动时，调用该函数，加载插件
     * classname StartLoadAddin
      * @param
     * @return boolean
     * @author  许杰
     * date   2018/4/20 22:04
     * @version 1.0
     */
    boolean StartLoadAddin();

    /**
     *  插件加载完成后，平台调用函数，可以完成插件初始化
     * classname FinishLoadAddin
      * @param
     * @return boolean
     * @author  许杰
     * date   2018/4/20 22:04
     * @version 1.0
     */
    boolean FinishLoadAddin();

    /**
     *  平台调用该函数，停止插件工作
     * classname StopAddin
      * @param
     * @return boolean
     * @author  许杰
     * date   2018/4/20 22:04
     * @version 1.0
     */
    boolean StopAddin();

    /**
     *  平台调用该函数，读取插件的版本号
     * classname Version
      * @param
     * @return java.lang.String
     * @author  许杰
     * date   2018/4/20 22:04
     * @version 1.0
     */
    String Version();

}

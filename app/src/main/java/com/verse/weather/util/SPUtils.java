package com.verse.weather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.verse.weather.App;

import java.io.*;
import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.N;

//实现标记的写入与读取
public class SPUtils {
    private static final String SP_NAME = "Happy";
    private static SharedPreferences sp;

    //保存布尔值
    public static void saveBoolean(Context context, String key, boolean value) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        boolean result = sp.getBoolean(key, defValue);
        return result;
    }

    //保存字符串
    public static void saveString(String key, String value) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key, value).apply();
    }

    public static String getString(String key, String defValue) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        String result = sp.getString(key, defValue);
        return result;
    }

    //保存-token
    public static void saveLong(String key, Long value) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key, value).apply();
    }

    public static Long getLong(String key) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        Long result = sp.getLong(key, 0);
        return result;
    }

    //保存int
    public static void saveInt(String key, int value) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(String key, int defValue) {
        if (sp == null) {
            sp = App.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        int result = sp.getInt(key, defValue);
        return result;
    }


    private Context context;
    private SharedPreferences sharedPreferences;

    public SPUtils(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("gesture", Context.MODE_PRIVATE);
    }

    //存取对象
    public static boolean writeObjectIntoLocal(Context context, String fileName, ArrayList<?> bean) {
        if (android.os.Build.VERSION.SDK_INT >= N) {
            try {
                // 通过openFileOutput方法得到一个输出流，方法参数为创建的文件名（不能有斜杠），操作模式
                @SuppressWarnings("deprecation")
                FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bean);//写入
                fos.close();//关闭输入流
                oos.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                // 通过openFileOutput方法得到一个输出流，方法参数为创建的文件名（不能有斜杠），操作模式
                @SuppressWarnings("deprecation")
                FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_WORLD_READABLE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bean);//写入
                fos.close();//关闭输入流
                oos.close();
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * 读取本地对象
     *
     * @param context
     * @param fielName 文件名
     * @return
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<?> readObjectFromLocal(Context context, String fielName) {
        ArrayList<?> bean = null;
        try {
            File file = new File(fielName);
            if (file.exists()) {
                FileInputStream fis = context.openFileInput(fielName);//获得输入流
                ObjectInputStream ois = new ObjectInputStream(fis);
                bean = (ArrayList<?>) ois.readObject();
                fis.close();
                ois.close();
            }

            return bean;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return null;
        } catch (OptionalDataException e) {
            e.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

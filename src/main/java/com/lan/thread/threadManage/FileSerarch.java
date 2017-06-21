package com.lan.thread.threadManage;

import java.io.File;

/**
 * Created by Administrator on 2017/6/21.
 * 线程中断的控制
 */
public class FileSerarch implements Runnable {

    private String initPath;
    private String fileName;

    public FileSerarch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if(file.isDirectory()){
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("%s: The serarch has been interrupted",Thread.currentThread().getName());
            }
        }
    }

    /**
     * 实现directoryProcess()方法，这个方法会获取一个文件夹里的所有文件和子文件夹，
     * 并进行处理，对于每一个目录，这个方法将递归调用，并且用相应目录名作为传入参数。
     * 对于每个文件，这个方法将调用fileProcess（）方法。处理完所有的文件和文件夹后，这个方法将
     * 检查线程是不是被中断了，如果是，就抛出InterruptedException异常。
     * @param file
     * @throws InterruptedException
     */
    private void directoryProcess(File file) throws InterruptedException {
        
        File list[] = file.listFiles();
        if(list!=null){
            for(int i=0;i<list.length;i++){
                if(list[i].isDirectory()){
                    directoryProcess(list[i]);
                }else{
                    fileProcess(list[i]);
                }
            }
        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    /**
     *实现processFile方法。这个方法将比较当前文件夹的文件名和要查找的文件名，如果文件名匹配
     * ，就将信息打印到控制台。做完比较后，线程将检查是不是被中断了，如果是，
     * 它将抛出InterruptedException异常
     * @param file
     */
    private void fileProcess(File file) throws InterruptedException {
        if(file.getName().equals(fileName)){
            System.out.printf("%s : %s\n",Thread.currentThread().getName(),file.getAbsoluteFile());

        }
        if(Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}

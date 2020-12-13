public class Main {

    static Globals global;

    public static void main(String args[])
    {



        FileSystem temp_file = new FileSystem();
        FileSystem temp_file2 = new FileSystem();
        FileSystem fileSystem = new FileSystem();
//        global.fs_booted = true;
//        global.fs_is_available = true;
        fileSystem.FS_Boot();
        temp_file.size = 10;
        temp_file2.size = 5;
        global.working_disk.file_table.add(temp_file);
        global.external_disk.file_table.add(temp_file2);


        System.out.println(global.external_disk.Disk_Init());





    }
}

public class Main {

    static Globals global;

    public static void main(String args[])
    {
        //Make FS available
        //file_table in working_disk has 10 files
        //file_table in external disk has 5 files


        Files temp_file = new Files();
        Files temp_file2 = new Files();
        FileSystem fileSystem = new FileSystem();
//        global.fs_booted = true;
//        global.fs_is_available = true;
        fileSystem.FS_Boot();
        temp_file.size = 10;
        temp_file2.size = 5;
        global.working_disk.file_table.add(temp_file);
        global.external_disk.file_table.add(temp_file2);
//        System.out.println("Before in working disk: " + global.working_disk.file_table.get(0).size);
//        System.out.println("Before in external disk: " + global.external_disk.file_table.get(0).size);
        System.out.println(fileSystem.FS_Sync());
//        System.out.println("After in working disk: " + global.working_disk.file_table.get(0).size);
//        System.out.println("After in external disk: " + global.external_disk.file_table.get(0).size);
        System.out.println(fileSystem.FS_Reset());
        System.out.println(fileSystem.FS_Boot());


    }
}

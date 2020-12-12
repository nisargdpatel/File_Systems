public class Main {

    static Globals global;

    public static void main(String args[])
    {

        Files temp_file = new Files();
        FileSystem fileSystem = new FileSystem();
//        global.fs_booted = true;
        temp_file.size = 10;
        global.external_disk.file_table.add(temp_file);
        System.out.println("Before: " + global.external_disk.file_table.get(0).size);
        fileSystem.FS_Boot();
        System.out.println("After: " + global.working_disk.file_table.get(0).size);

    }
}

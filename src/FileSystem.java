public class FileSystem {
    public static Globals global = new Globals();

    int FS_Boot()
    {
        if (global.fs_booted || global.fs_is_available)
        {
            global.osErrMsg = "E_FILE_BOOT";
            return -1;
        }
            if (global.external_disk_image_exists)
            {
                global.fs_is_available = true;
                return 0;
            } else {
                global.external_disk_image_exists = true;
                //TODO: Copy external_disk into working_disk
                for (int i = 0; i < global.external_disk.file_table.size() && global.external_disk.file_table.size() > 0; i++)
                {
                    global.working_disk.file_table.add(i, global.external_disk.file_table.get(i));
                }
                if(global.working_disk_exists)
                {
                    global.fs_is_available = true;
                    return 0;
                } else {
                    global.osErrMsg = "E_FILE_BOOT";
                    return -1;
                }
            }
    }


    int FS_Sync()
    {
        if (global.fs_is_available)
        {
            //TODO: Copy working_disk contents into external_disk
            return 0;
        } else {
            return -1;
        }
    }


    int FS_Reset() {
        global.fs_is_available = false;
        int result = FS_Sync();
        if (result == 0)
        {
            return 0;
        } else {
            global.osErrMsg = "E_FILE_RESET";
            return -1;
        }
    }



}

package ph.phone;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PhoneBookTextRepository implements IPhoneBookRepository<IPhoneBook>{
    private String fileName;

    public PhoneBookTextRepository(String fileName){
        this.fileName = fileName;
    }

    public IPhoneBook getObjectFromText(String str) throws Exception{
        if ( str == null ){
            throw new Exception("Error : Input str is null");
        }
        IPhoneBook object = new PhoneBook();
        String[] items = str.split(",");
        object.setId(Long.parseLong(items[0]));
        object.setName(items[1]);
        object.setGroup((EPhoneGroup.valueOf(items[2])));
        object.setPhoneNumber(items[3]);
        object.setEmail(items[4]);
        return object;
    }

    public String getTextFromObject(IPhoneBook object) throws Exception{
        if ( object == null ){
            throw new Exception("Error : Input object is null");
        }

        String str = String.format("%d, %s, %s, %s, %s\n"
                ,object.getId(), object.getName(), object.getGroup()
                , object.getPhoneNumber(), object.getEmail());
        return str;
    }

    @Override
    public boolean saveData(List<IPhoneBook> listData) throws Exception {
        if ( listData == null || listData.size() <= 0 ){
            return false;
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        OutputStreamWriter writer = new OutputStreamWriter(fileOut, StandardCharsets.UTF_8);
        for ( IPhoneBook object : listData ){
            String str = getTextFromObject(object);
            writer.write(str);
        }

        writer.close();
        return false;
    }

    @Override
    public boolean loadData(List<IPhoneBook> listData) throws Exception {
        File file = new File(fileName);
        if ( !file.exists()){
            return true;
        }

        BufferedReader inFile = new BufferedReader(new FileReader((file)));
        String sLine = null;
        listData.clear();
        while((sLine = inFile.readLine()) != null){
            IPhoneBook object = this.getObjectFromText(sLine);
            listData.add(object);
        }
        return false;
    }
}

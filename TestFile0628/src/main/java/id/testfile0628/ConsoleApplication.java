package id.testfile0628;

import java.util.Scanner;

public class ConsoleApplication {
    public void printTitle(){
        System.out.println("=================================================================");
        System.out.println("1. 연락처 생성 | 2. 목록 | 3. 수정 | 4. 삭제 | 5. 이름 검색 | 6. 연락처 검색 | 7. 그룹 검색 | 8. 이메일 검색 | 9. 종료");
        System.out.println("=================================================================");
    }
    public int getChoice(Scanner sc){
        int choice = 0;
        while(true) {
            System.out.println("선택 >> ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:

                case 6:

                case 7:

                case 8:

                case 9:
                    System.out.println("파일이 종료됩니다");
                    break;
            }
        }
    }
}

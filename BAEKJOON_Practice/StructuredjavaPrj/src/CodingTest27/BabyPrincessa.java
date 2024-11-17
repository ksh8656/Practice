package CodingTest27;

import java.util.Scanner;

public class BabyPrincessa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성하여 입력 받기

        System.out.println("테스트 케이스의 개수를 입력하시오:");
        int testcase = sc.nextInt(); // 테스트 케이스의 수 입력
        int[] num1 = new int[testcase]; // 각 테스트 케이스의 결과를 저장할 배열

        // 각 테스트 케이스 처리
        for (int i = 0; i < testcase; i++) {
            int num = 0; // 행성을 지나간 횟수
            // 시작 점의 좌표와 끝 점의 좌표 입력
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int planetCount = sc.nextInt(); // 행성의 개수 입력

            // Planet 객체 배열 생성
            Planet[] planets = new Planet[planetCount];

            // 행성 정보 입력
            for (int k = 0; k < planetCount; k++) {
                // 각 행성의 중심 좌표와 반지름 입력
                int centerX = sc.nextInt();
                int centerY = sc.nextInt();
                int radius = sc.nextInt();
                // Planet 객체 생성 후 배열에 저장
                planets[k] = new Planet(centerX, centerY, radius);
            }

            // 두 점과 행성 간의 관계 분석
            for (Planet planet : planets) {
                // 시작 점과 끝 점이 각 행성 내부에 있는지 확인
                boolean isFirstInside = planet.isInside(x1, y1);
                boolean isSecondInside = planet.isInside(x2, y2);

                // 두 점 중 하나는 안쪽, 다른 점은 바깥쪽일 경우
                if (isFirstInside != isSecondInside) {
                    num++; // 행성을 지나간 횟수 증가
                }
            }
            num1[i] = num; // 결과 배열에 행성을 지나간 횟수 저장
        }

        // 결과 출력
        for (int h = 0; h < testcase; h++) {
            System.out.println(num1[h]); // 각 테스트 케이스의 결과 출력
        }

        sc.close(); // Scanner 객체 닫기
    }
}
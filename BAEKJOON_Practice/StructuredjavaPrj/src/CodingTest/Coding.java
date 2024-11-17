package CodingTest;
import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수 입력
        int testCases = sc.nextInt();
        
        // 결과를 저장할 배열 생성
        int[] results = new int[testCases];
        
        // 각 테스트 케이스에 대해 처리
        for (int i = 0; i < testCases; i++) {
            // 입력: 조규현의 좌표 (x1, y1), 백승환의 좌표 (x2, y2), 각각의 적과의 거리 r1, r2
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();
            
            // 두 터렛 사이 거리의 제곱 (sqrt 없이 제곱으로 처리)
            int distanceSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            
            // 두 원의 반지름 합의 제곱, 차의 제곱
            int rSumSquared = (r1 + r2) * (r1 + r2); // (r1 + r2)^2
            int rDiffSquared = (r1 - r2) * (r1 - r2); // (r1 - r2)^2
            
            // 경우에 따른 처리
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                results[i] = -1; // 무한히 많은 점
            } else if (distanceSquared > rSumSquared) {
                results[i] = 0; // 두 원이 만나지 않음
            } else if (distanceSquared < rDiffSquared) {
                results[i] = 0; // 한 원이 다른 원 안에 있지만 만나지 않음
            } else if (distanceSquared == rSumSquared || distanceSquared == rDiffSquared) {
                results[i] = 1; // 한 점에서 만남
            } else {
                results[i] = 2; // 두 점에서 만남
            }
        }
        
        // 결과 출력
        for (int i = 0; i<testCases; i++) {
            System.out.println(results[i]);
        }
        
        sc.close(); // Scanner 객체 닫기
    }
}
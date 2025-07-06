# Minikube vs Kubernetes (운영 클러스터) 비교

Kubernetes 학습을 위한 로컬 환경인 **Minikube**와 실제 운영 환경에서 사용하는 **클러스터 기반 Kubernetes**의 차이점을 구조적/기능적 관점에서 비교합니다.

---

## ✅ 공통점: Minikube도 실제 Kubernetes이다

| 핵심 컴포넌트        | Minikube | 일반 Kubernetes |
|---------------------|----------|------------------|
| API Server          | ✅       | ✅               |
| Controller Manager  | ✅       | ✅               |
| Scheduler           | ✅       | ✅               |
| etcd                | ✅       | ✅               |
| Kubelet             | ✅       | ✅               |
| Kube-Proxy          | ✅       | ✅               |
| Container Runtime   | ✅       | ✅               |

> ✅ Minikube도 Kubernetes의 모든 기본 컴포넌트를 포함하므로, 실제 `kubectl` 명령과 오브젝트들을 실습 가능

---

## ❗ 차이점: 구조 및 운영환경 관점

| 항목                     | Minikube (개발용)                     | 일반 Kubernetes (운영용)                |
|--------------------------|---------------------------------------|-----------------------------------------|
| 클러스터 구성            | 단일 노드 (모든 역할이 1개 노드에 존재) | Master + 여러 Worker로 분산 구성       |
| etcd 구성                | 단일 인스턴스                         | 3개 이상의 etcd 구성 (HA)              |
| Node 확장성              | 1개 고정                              | 수십~수백 개 노드 확장 가능            |
| 네트워크 플러그인(CNI)   | 자동 포함 (간단 구성)                  | 직접 설치 필요 (Calico, Flannel 등)    |
| 스토리지 구성            | hostPath 기반                         | CSI 기반 외부 스토리지 연동            |
| LoadBalancer             | 없음 (`minikube tunnel`로 대체)        | 클라우드 LB 또는 MetalLB 구성          |
| 장애 복구                | 불가능 (모든 컴포넌트가 1노드에 존재)   | 고가용성 구성 (ControlPlane 분산 등)   |

---

## 🎯 결론: Minikube로 Kubernetes 개념 학습은 충분하다

| 실습 항목                          | Minikube로 가능 여부 |
|-----------------------------------|----------------------|
| Pod/Service/Deployment 실습       | ✅ 가능               |
| ReplicaSet, ConfigMap 등 실습     | ✅ 가능               |
| Volume, PVC/PV 실습               | ✅ 가능 (hostPath 기반) |
| Helm, Ingress 실습                | ✅ 가능               |
| 클러스터 확장, 장애 테스트        | ❌ 불가능             |
| 실제 운영 환경 시뮬레이션        | ❌ 제한적             |

---

## ✅ 요약

- Minikube는 **Kubernetes 구조와 명령어를 완벽하게 학습**할 수 있는 강력한 로컬 도구
- 다만 **운영 환경의 고가용성, 멀티 노드 구성 등은 체험이 불가**
- Kubernetes의 기본기를 익힌 후, 필요시 **Kind, k3s, GKE/EKS** 등으로 확장하는 것이 이상적

---

--
-- PostgreSQL database dump
--

\restrict vbChNadzEeQK6NNlzt8Sre1dPB0gdLSkzOqt5tBv65Tq2PhQa70mdtvX09QCr3K

-- Dumped from database version 18.0
-- Dumped by pg_dump version 18.0

-- Started on 2025-10-26 10:16:17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 16723)
-- Name: comments; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.comments (
    id bigint NOT NULL,
    content text NOT NULL,
    created_at timestamp(6) with time zone,
    author_id bigint,
    post_id bigint
);


--
-- TOC entry 219 (class 1259 OID 16722)
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5040 (class 0 OID 0)
-- Dependencies: 219
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.comments_id_seq OWNED BY public.comments.id;


--
-- TOC entry 222 (class 1259 OID 16734)
-- Name: posts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.posts (
    id bigint NOT NULL,
    content text,
    created_at timestamp(6) with time zone,
    title character varying(255) NOT NULL,
    updated_at timestamp(6) with time zone,
    author_id bigint
);


--
-- TOC entry 221 (class 1259 OID 16733)
-- Name: posts_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.posts_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5041 (class 0 OID 0)
-- Dependencies: 221
-- Name: posts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.posts_id_seq OWNED BY public.posts.id;


--
-- TOC entry 224 (class 1259 OID 16745)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 16744)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 5042 (class 0 OID 0)
-- Dependencies: 223
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 4866 (class 2604 OID 16726)
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comments ALTER COLUMN id SET DEFAULT nextval('public.comments_id_seq'::regclass);


--
-- TOC entry 4867 (class 2604 OID 16737)
-- Name: posts id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts ALTER COLUMN id SET DEFAULT nextval('public.posts_id_seq'::regclass);


--
-- TOC entry 4868 (class 2604 OID 16748)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 5030 (class 0 OID 16723)
-- Dependencies: 220
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 5032 (class 0 OID 16734)
-- Dependencies: 222
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.posts VALUES (2, 'This is my second post created via API.', '2025-10-25 11:16:00.962195+05:30', 'My Second Blog Post', NULL, 1);


--
-- TOC entry 5034 (class 0 OID 16745)
-- Dependencies: 224
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES (1, 'vaishnavi@gmail.com', '$2a$10$rIm3nREwaoAaJyqLZy2kuuA9lnDztTggRQRZtdruZtX/9u4UJZrj2', 'USER', 'vaishnavi');


--
-- TOC entry 5043 (class 0 OID 0)
-- Dependencies: 219
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.comments_id_seq', 1, true);


--
-- TOC entry 5044 (class 0 OID 0)
-- Dependencies: 221
-- Name: posts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.posts_id_seq', 2, true);


--
-- TOC entry 5045 (class 0 OID 0)
-- Dependencies: 223
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 1, true);


--
-- TOC entry 4870 (class 2606 OID 16732)
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- TOC entry 4872 (class 2606 OID 16743)
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (id);


--
-- TOC entry 4874 (class 2606 OID 16759)
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- TOC entry 4876 (class 2606 OID 16761)
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- TOC entry 4878 (class 2606 OID 16757)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4881 (class 2606 OID 16772)
-- Name: posts fk6xvn0811tkyo3nfjk2xvqx6ns; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT fk6xvn0811tkyo3nfjk2xvqx6ns FOREIGN KEY (author_id) REFERENCES public.users(id);


--
-- TOC entry 4879 (class 2606 OID 16767)
-- Name: comments fkh4c7lvsc298whoyd4w9ta25cr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT fkh4c7lvsc298whoyd4w9ta25cr FOREIGN KEY (post_id) REFERENCES public.posts(id);


--
-- TOC entry 4880 (class 2606 OID 16762)
-- Name: comments fkn2na60ukhs76ibtpt9burkm27; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.comments
    ADD CONSTRAINT fkn2na60ukhs76ibtpt9burkm27 FOREIGN KEY (author_id) REFERENCES public.users(id);


-- Completed on 2025-10-26 10:16:18

--
-- PostgreSQL database dump complete
--

\unrestrict vbChNadzEeQK6NNlzt8Sre1dPB0gdLSkzOqt5tBv65Tq2PhQa70mdtvX09QCr3K


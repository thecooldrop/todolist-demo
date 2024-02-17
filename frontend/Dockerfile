FROM node:21-alpine3.19 as build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Stage 2: Serve the application from Nginx
FROM nginx:1.25.4
COPY --from=build /app/dist/frontend/browser /usr/share/nginx/html
EXPOSE 80